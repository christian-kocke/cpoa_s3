/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Aïssa
 */
public class DaoProjection {
    
    public Connection connect;
    
    //On effectue la connection grâce à ConfigConnection et au fichier de propriétés
    public DaoProjection() throws DaoException {
        try {
            this.connect = ConfigConnection.getConnection("fichier_propriete.properties");
        } catch (IOException ex) {
            throw new DaoException("Problème pour lire le fichier de configuration",
            ex);
        } catch (ClassNotFoundException ex) {
            throw new DaoException("Impossible de trouver la classe du driver JDBC",
            ex);
        } catch (SQLException ex) {
            throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    }
    
     //Instanciation d'un Dao
    public static DaoProjection getDAO() throws DaoException {
                DaoProjection dao = new DaoProjection();
                return dao;
    }
    
   
    public Collection<Projection> ProjectionPrevues(String titre) throws DaoException {
                try {
                    String recherche_id_film = "Select id from FILM where nom = '" +titre+ "'";
                    ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_id_film);
                    rs.next();
                    int id_film= rs.getInt("id");
                    
                    String projections_prevues = "Select * from PROJECTION where id_film =" + Integer.toString(id_film);
                    rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(projections_prevues);
                    
                    Collection<Projection> col;
                    col = new ArrayList();
            
                    while (rs.next()) {
                        col.add(new Projection(rs.getInt("id"),rs.getInt("id_type"),rs.getInt("id_salle"),
                        rs.getInt("id_premier_creneau")));
                    }
                    
                    return col;
                }
                
                catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
    
    public Collection<String> TypeDeProjectionPrevue(String titre) throws DaoException {
        try
        {
        String recherche_id_film = "Select id from FILM where nom = '" +titre+ "'";
        ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_id_film);
        rs.next();
        int id_film= rs.getInt("id");
        
        String recherche_projections="Select libelle FROM TYPE where id in (Select id_type FROM PROJECTION where id_film=" + 
                Integer.toString(id_film) +")";
        rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_projections);
        Collection<String> col;
        col = new ArrayList();
        
        while (rs.next()) {
                        col.add(rs.getString("libelle"));
                    }
        return col;
        
        }
        catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
    
    //Renvoie une collection de tous les creneaux d'un certain jour pour une certaine salle et une 
    //préference de créneau
    //date doit être sous le format AAAA-MM-JJ
    public Collection<Projection> ProjectionsDuJour(String date, String salle, String preference) throws DaoException {
        try {
            
//Récuperation de l'id de la salle
            String recherche_id_salle = "Select id from SALLE where nom ='"+salle+"'";
                    ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                                 ResultSet.CONCUR_UPDATABLE).
                                                                executeQuery(recherche_id_salle);
            rs.next();
            int id_salle = rs.getInt("id");
            
            String recherche_creneau = null;
            
            if (preference.equals("Aucune"))
                {
                    recherche_creneau= "Select * from PROJECTION where id_salle="+id_salle+" AND id_premier_creneau in"
                            + "(Select id from CRENEAU where jour='"+date+"' Order by heure_debut ASC)";
                }
            
            else if(preference.equals("Matinée")) {
                     recherche_creneau = "Select * from PROJECTION where id_salle="+id_salle+" AND id_premier_creneau in"
                            + "(Select id from CRENEAU where jour='"+date+"' and heure_debut<'12:00:00' Order by heure_debut ASC)";
            }
            
            else if(preference.equals("Après-midi")) {
                    recherche_creneau = "Select * from PROJECTION where id_salle="+id_salle+" AND id_premier_creneau in"
                            + "(Select id from CRENEAU where jour='"+date+"' and heure_debut>'12:00:00'"
                            + "and heure_debut<'19:00:00' Order by heure_debut ASC)";
            }
            
            else if(preference.equals("Soirée")) {
                    recherche_creneau = "Select * from PROJECTION where id_salle="+id_salle+" AND id_premier_creneau in"
                            + "(Select id from CRENEAU where jour='"+date+"' and heure_debut>'19:00:00' Order by heure_debut ASC)";
            }
            
            rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                                 ResultSet.CONCUR_UPDATABLE).
                                                                executeQuery(recherche_creneau);
            Collection<Projection> col;
            col = new ArrayList();
            
            DaoFilm daoF = DaoFilm.getDAO();
            DaoCreneau daoC = DaoCreneau.getDAO();
            int duree;
            String heure;
            
            while (rs.next()) {
                duree=daoF.dureeFilm(rs.getInt("id_film"));
                heure=daoC.getHeure(rs.getInt("id_premier_creneau"));
                col.add(new Projection(rs.getInt("id"),rs.getInt("id_type"), rs.getInt("id_salle"), heure, duree));
            }
            
            return col;
        }
        
        catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
        
    }
    
    
    public void insérerProjection(String type_proj, String salle, String date_sql, String heure_choisie, String titre) throws DaoException {
        try {
            ResultSet rs;
            
            //ID TYPE PROJECTION
            String recherche= "Select id from TYPE where libelle ='"+type_proj+"'";
            rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche);
            rs.next();
            int id_type_proj = rs.getInt(1);
            
            
            
            //ID FILM
            recherche = "Select id from FILM where nom ='"+titre+"'";
            rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche);
            rs.next();
            int id_film = rs.getInt(1);
            
            //ID CONCOURS
            recherche = "Select id_concours from FILM where nom='"+titre+"'";
            rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche);
            rs.next();
            int id_concours = rs.getInt(1);
            
            //ID SALLE
            recherche = "Select id from SALLE where nom ='"+salle+"' AND id_concours="+id_concours;
            rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche);
            rs.next();
            int id_salle = rs.getInt(1);
            
            //ID PLANNING
            recherche = "Select id from PLANNING where id_concours="+id_concours;
            rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche);
            rs.next();
            int id_planning = rs.getInt(1);
            
            //Insertion créneau
            DaoCreneau daoC = DaoCreneau.getDAO();
            daoC.create(heure_choisie,id_planning,date_sql);
            
            //ID CRENEAU
            recherche ="Select id from CRENEAU where heure_debut='"+heure_choisie+"' AND id_planning="+id_planning+" AND "
                    + "jour='"+date_sql+"'";
            
            rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche);
            rs.next();
            int id_premier_creneau = rs.getInt(1);
            
            this.create(id_film,id_type_proj,id_salle,id_concours,id_premier_creneau);
        }
        
        catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
    
    //Insère une nouvelle projection dans la table
    public void create(int id_film, int id_type, int id_salle, int id_concours, int id_premier_creneau) throws DaoException {
        
        try {
            String insert = "insert into PROJECTION (id_film, id_type, id_salle, id_concours, id_premier_creneau) values"
                    + "("+id_film+","+id_type+","+id_salle+","+id_concours+","+id_premier_creneau+")";

            PreparedStatement PrepStat = this.connect.prepareStatement(insert);
            PrepStat.executeUpdate();
            
            
        } catch (SQLException ex) {
            throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    }
    
}
