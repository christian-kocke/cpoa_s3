
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aïssa
 */
public class authentificationApp {
    
    public static void main(String[] args) {
    
    
    SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Authentification c = new Authentification();
            }
        });
    
    }
    
    
}
