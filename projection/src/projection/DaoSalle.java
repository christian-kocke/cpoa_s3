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
public class DaoSalle {
    
     public Connection connect;
    
    //On effectue la connection grâce à ConfigConnection et au fichier de propriétés
    public DaoSalle() throws DaoException {
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
    public static DaoSalle getDAO() throws DaoException {
                DaoSalle dao = new DaoSalle();
                return dao;
    }
    
    public String nomSalle(int id) throws DaoException {
       try {
           String recherche_nom="Select nom from SALLE where id =" + Integer.toString(id);
           ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_nom);
           rs.next();
           String nom = rs.getString("nom");
           return nom;
       }
       
       catch (SQLException ex) {
               throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    
    }
    
    //Renvoi collection de Salle dans lesquels le film peut être projeté
    public Collection<Salle> salleParType(String titre) throws DaoException {
       
        try {
            String recherche_salle="Select id, nom from SALLE where id_concours in (Select id_concours from FILM where nom = '"+titre+"')";
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_salle);
            Collection<Salle> col;
            col = new ArrayList();
            
            while (rs.next()) {
                    col.add(new Salle(rs.getInt("id"),rs.getString("nom")));
            }
                    
                    
            return col;
        }
        
        catch (SQLException ex) {
               throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    }
    
}
