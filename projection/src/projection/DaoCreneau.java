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
public class DaoCreneau {
    
    public Connection connect;
    
    //On effectue la connection grâce à ConfigConnection et au fichier de propriétés
    public DaoCreneau() throws DaoException {
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
    public static DaoCreneau getDAO() throws DaoException {
                DaoCreneau dao = new DaoCreneau();
                return dao;
    }
    
    public String heureDebut(int id) throws DaoException {
        try {
            String recherche_heure= "Select heure_debut from CRENEAU where id = " + Integer.toString(id);
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_heure);
           rs.next();
           String heure = rs.getString("heure_debut");
           return heure;
        }
        
        catch (SQLException ex) {
               throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    }
    
    public String date(int id) throws DaoException {
        try {
            String recherche_date= "Select jour from CRENEAU where id = " + Integer.toString(id);
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_date);
           rs.next();
           String jour = rs.getString("jour");
           return jour;
        }
        
        catch (SQLException ex) {
               throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    }
    
    //Insère un nouveau créneau dans la table
    public void create(String heure, int id_planning, String jour) throws DaoException {
        
        try {
            String insert = "insert into CRENEAU (heure_debut, id_planning, jour) values('"+heure+"',"+id_planning+""
                    + ",'"+jour+"')";

            PreparedStatement PrepStat = this.connect.prepareStatement(insert);
            PrepStat.executeUpdate();
            
            
        } catch (SQLException ex) {
            throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    }
    
    public String getHeure(int id) throws DaoException {
        try {
            String recherche_heure="Select heure_debut from CRENEAU where id="+id;
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_heure);
           rs.next();
           return rs.getString("heure_debut");
        }
        
        catch (SQLException ex) {
               throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    }
}
