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

/**
 *
 * @author Aïssa
 */
public class DaoUser {
    
    public Connection connect;
    
     //On effectue la connection grâce à ConfigConnection et au fichier de propriétés
    public DaoUser() throws DaoException {
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
    public static DaoUser getDAO() throws DaoException {
                DaoUser dao = new DaoUser();
                return dao;
    }
    
    public String login(String user, String mdp) throws DaoException {
        try {
            
            //Recherche si l'utilisateur existe
            String recherche = "Select COUNT(id) from UTILISATEUR where user='"+user+"'";
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche);
           rs.next();
           if(rs.getInt(1)==0) {
               return "Ce nom d'utilisateur n'existe pas";
           }
           
           else {
               recherche = "Select mdp, role from UTILISATEUR where user='"+user+"'";
               rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche);
               rs.next();
               //Test de l'autorisation
               if (!rs.getString(2).equalsIgnoreCase("Responsable festival")) {
                    return "Utilisateur non autorisé";
           }
               else {
                   //Test du mot de passe
                   if(rs.getString(1).equals(mdp)) {
                       return "OK";
                   }
                   else {
                       return "Mot de passe incorrect";
                   }
               }
           }
            
        }
        
        catch (SQLException ex) {
            throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    }
}
