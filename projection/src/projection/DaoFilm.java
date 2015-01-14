/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
    
}
