/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                    String findFilmAPlacer = "Select * From FILM where id not in (Select id_film from PROJECTION)";
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
                         findFilmAPlacer = "Select * From FILM where id not in (Select id_film from PROJECTION) and duree " + duree;
                    }
                    else {
                        String recherche_id_concours = "Select id from CONCOURS where libelle = '" +concours+ "'";
                        rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_id_concours);
                        rs.next();
                        int id_concours = rs.getInt("id");
                        findFilmAPlacer = "Select * From FILM where id not in (Select id_film from PROJECTION) and id_concours= "
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
    
    
}
