package projection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Aïssa
 */
public class DaoFilm {
    
    public Connection connect;
    
    //On effectue la connection grâce à ConfigConnection et au fichier de propriétés
    public DaoFilm() throws DaoException {
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
    public static DaoFilm getDAO() throws DaoException {
                DaoFilm dao = new DaoFilm();
                return dao;
    }
    
    //On récupere ici une liste de tous les films pas encore placés
    public Collection<Film> filmAPlacer() throws DaoException {
                try {
                    String findFilmAPlacer = "Select * From FILM";
                    ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(findFilmAPlacer);
                    Collection<Film> col;
                    col = new ArrayList();
            
                    while (rs.next()) {
                    col.add(new Film(rs.getInt("id"),rs.getString("nom"),
                    rs.getInt("duree")));
                    }
                    
                    return col;
                }
                
                catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
    
    //Récupère une collection de film d'après le concours et la durée
    public Collection<Film> filmAPlacerParCategorie(String concours, String duree) throws DaoException {
                try {
                    
                    ResultSet rs;
                    String findFilmAPlacer;
                    if (concours.equals("Toutes")) {
                         findFilmAPlacer = "Select * From FILM where duree " + duree;
                    }
                    else {
                        String recherche_id_concours = "Select id from CONCOURS where libelle = '" +concours+ "'";
                        rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_id_concours);
                        rs.next();
                        int id_concours = rs.getInt("id");
                        findFilmAPlacer = "Select * From FILM where id_concours= "
                            +Integer.toString(id_concours)+" and duree " + duree;
                    }
                    
                    rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(findFilmAPlacer);
                    Collection<Film> col;
                    col = new ArrayList();
            
                    while (rs.next()) {
                    col.add(new Film(rs.getInt("id"),rs.getString("nom"),
                    rs.getInt("duree")));
                    }
                    
                    return col;
                }
                
                catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
    
    //Test le nombre de film déjà placés par jour selon contraintes, revoie true si on peut encore en placer au moins un
    public boolean testNbFilmParJour(String titre, String date) throws DaoException {
        
        try {
            String recherche_concours = "Select libelle from CONCOURS where id in (Select id_concours from FILM where nom ='"+titre+"')";
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_concours);
            rs.next();
            if (rs.getString("libelle").equals("Court métrage") || rs.getString("libelle").equals("Hors compétition") ) {
                return true;
        }
            else if (rs.getString("libelle").equals("Long métrage")) {
                String recherche_nb = "Select COUNT(id) from PROJECTION where id_premier_creneau in"
                        + "(Select id from CRENEAU where jour='"+date+"') AND id_concours=1";
                rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_nb);
                rs.next();
                if (rs.getInt(1) >= 3) {//Contrainte de maximum 3 Long métrage par jour
                    return false;
                }
                else {
                    return true;
                }
            }
            
            else if (rs.getString("libelle").equals("Un certain regard")) { 
                String recherche_nb = "Select COUNT(id) from PROJECTION where id_premier_creneau in"
                        + "(Select id from CRENEAU where jour='"+date+"') AND id_concours=4";
                rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_nb);
                rs.next();
                if (rs.getInt(1) >= 4) {//Contrainte de maximum 4 Un certain regard par jour
                    return false;
                }
                else {
                    return true;
                }
            }
            
        }
        
        catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
        return true;
    }
    
    public int dureeFilm (int id) throws DaoException {
        
        try {
            String recherche_duree = "Select duree from FILM where id="+id;
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_duree);
            rs.next();
            return rs.getInt("duree");
        }
        
        catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
    
    public int idFilm(String titre) throws DaoException {
        try{
            String recherche = "Select id from FILM where nom='"+titre+"'";
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche);
            rs.next();
            return rs.getInt("id");
        }
        
        catch(SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
}
