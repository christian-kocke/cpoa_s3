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
public class DaoPlanning {
    
    public Connection connect;
    
    //On effectue la connection grâce à ConfigConnection et au fichier de propriétés
    public DaoPlanning() throws DaoException {
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
    public static DaoPlanning getDAO() throws DaoException {
                DaoPlanning dao = new DaoPlanning();
                return dao;
    }
    
    //Retourne le noms des concours pour lesquels un planning existe déjà
    public Collection<String> PlanningCrees() throws DaoException {
        try {
            String recherche_planning = "Select libelle from CONCOURS where id in (Select id_concours from PLANNING)";
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_planning);
            
            Collection<String> col;
            col = new ArrayList();
            
            while(rs.next()) {
                col.add(rs.getString("libelle"));
            }
            
            return col;
        }
        catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
    
    //Verifie que le planning du concours d'un film a été crée, retourne true si oui, false sinon
    public boolean PlanningExiste(String titre) throws DaoException {
        
        try {
            String recherche_planning = "Select COUNT(id) from PLANNING where id_concours in (Select id_concours from"
                    + " FILM where nom ='"+titre+"')";
             ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_planning);
             rs.next();
             
             if(rs.getInt(1)<=0) {
                 return false;
             }
             
             else {
                 return true;
             }
        }
        
        catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
    
    public boolean PlanningExiste2(String concours) throws DaoException {
        
        try {
            String recherche_planning = "Select COUNT(id) from PLANNING where id_concours in (Select id_concours from"
                    + " CONCOURS where libelle ='"+concours+"')";
             ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_planning);
             rs.next();
             
             if(rs.getInt(1)<=0) {
                 return false;
             }
             
             else {
                 return true;
             }
        }
        
        catch (SQLException ex) {
                    throw new DaoException("Impossible d'ouvrir une connexion", ex); 
                }
    }
    
    //Insertion d'un nouveau planning dans la table
    public void create(Planning p) throws DaoException {
        
        try {
            String recherche_id_concours="Select id from CONCOURS where libelle = '" +p.getConcours()+"'";
            ResultSet rs = this.connect.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE).
                                                        executeQuery(recherche_id_concours);
            rs.next();
            int id_concours = rs.getInt("id");
            
            String insert = "insert into PLANNING (id_concours) values("+id_concours+")";
            PreparedStatement PrepStat = this.connect.prepareStatement(insert);
            
            PrepStat.executeUpdate();
            
            
        } catch (SQLException ex) {
            throw new DaoException("Impossible d'ouvrir une connexion", ex); 
        }
    }
    
}
