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

//Dao pour le type de projection (officielle, presse ...)
public class DaoType {
     
    public Connection connect;
    
    //On effectue la connection grâce à ConfigConnection et au fichier de propriétés
    public DaoType() throws DaoException {
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
    public static DaoType getDAO() throws DaoException {
                DaoType dao = new DaoType();
                return dao;
    }
    
     public String nomType(int id) throws DaoException {
       try {
           String recherche_nom="Select libelle from TYPE where id =" + Integer.toString(id);
           ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_nom);
           rs.next();
           String nom = rs.getString("libelle");
           return nom;
       }
       
       catch (SQLException ex) {
               throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    
    }
    
    
}
