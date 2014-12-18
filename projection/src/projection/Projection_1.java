/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author p1303891
 */
public class Projection_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        db conn = db.getInstance();
        ArrayList l = new ArrayList();
        l.add(123);
        ResultSet rslt = conn.query("select * from FILM");
        while(rslt.next()){
            System.out.println(rslt.getString("nom"));
        }
        
    }
    
}
