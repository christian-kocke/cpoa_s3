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
    
    
    
    
}
