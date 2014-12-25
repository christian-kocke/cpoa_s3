/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian
 */
public class db  {
    private static final db instance = new db();
    private Connection connection = null;
    
    private db() throws IOException {
        
        Properties props = new Properties();
        URL urlFichierProp = ConfigConnection.class.getResource("fichier_propriete.properties");
        BufferedInputStream bis;
        
        try {
          bis = new BufferedInputStream(urlFichierProp.openStream());
          props.load(bis);
          String name = props.getProperty("name");
                
          Class.forName(name);

        } catch (ClassNotFoundException e) {

                System.out.println("Where is your Oracle JDBC Driver?");

        }
        try {
                bis = new BufferedInputStream(urlFichierProp.openStream());
                props.load(bis);
                String driver = props.getProperty("driver");
                String url = props.getProperty("url");
                String utilisateur = props.getProperty("utilisateur");
                String mdp = props.getProperty("mdp");
                connection = DriverManager.getConnection(
                                url, utilisateur,mdp);

        } catch (SQLException e) {
               
                System.out.println("Connection Failed! Check output console");
        }
    }

    public static db getInstance(){
        return instance;
    }
    
    public ResultSet query(String query, ArrayList ... params){
        if(params.length > 0){
          try {
                PreparedStatement ps = connection.prepareStatement(query);
                for(int i = 1;i < params[0].size()+1;i++){
                    ps.setObject(i, params[0].get(i-1));
                }
                ResultSet rslt = ps.executeQuery();
                return rslt;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } 
        }else{
            Statement stmt;
            try {
                stmt = connection.createStatement();
                ResultSet rslt = stmt.executeQuery(query);
                return rslt;
            } catch (SQLException ex) {
                Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
    