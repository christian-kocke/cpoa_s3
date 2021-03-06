

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import projection.DaoException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aïssa
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     * @param nom
     */
    public Menu(String nom) {
        initComponents();
        this.setLocationRelativeTo(null);
        jLabel1.setText(nom+" (Connecté)");
        jLabel1.setVisible(true);
    }
    
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        b1 = new javax.swing.JLabel();
        b2 = new javax.swing.JLabel();
        b3 = new javax.swing.JLabel();
        b4 = new javax.swing.JLabel();
        b5 = new javax.swing.JLabel();
        reduce = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(791, 578));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 20));

        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/creer_default.png"))); // NOI18N
        b1.setText("jLabel1");
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b1MouseExited(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 160, 50));

        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/consulter_default.png"))); // NOI18N
        b2.setText("jLabel1");
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b2MouseExited(evt);
            }
        });
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 160, 50));

        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inserer_default.png"))); // NOI18N
        b3.setText("jLabel1");
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b3MouseExited(evt);
            }
        });
        getContentPane().add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 160, 50));

        b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/attribuer1_default.png"))); // NOI18N
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b4MouseExited(evt);
            }
        });
        getContentPane().add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 260, 40));

        b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/attribuer2_default.png"))); // NOI18N
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b5MouseExited(evt);
            }
        });
        getContentPane().add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 360, 260, 40));

        reduce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reduire2_default.png"))); // NOI18N
        reduce.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reduceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reduceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reduceMouseExited(evt);
            }
        });
        getContentPane().add(reduce, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 20, 20));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fermer_default.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 5, 20, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reduceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduceMouseClicked
        this.setState(1);
    }//GEN-LAST:event_reduceMouseClicked

    private void reduceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduceMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/reduire2_hover.png"));
        reduce.setIcon(II);
    }//GEN-LAST:event_reduceMouseEntered

    private void reduceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduceMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/reduire2_default.png"));
        reduce.setIcon(II);
    }//GEN-LAST:event_reduceMouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/fermer_hover.png"));
        close.setIcon(II);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/fermer_default.png"));
        close.setIcon(II);
    }//GEN-LAST:event_closeMouseExited

    private void b5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/attribuer2_hover.png"));
        b5.setIcon(II);
    }//GEN-LAST:event_b5MouseEntered

    private void b5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseExited
       ImageIcon II = new ImageIcon(getClass().getResource("Images/attribuer2_default.png"));
        b5.setIcon(II);
    }//GEN-LAST:event_b5MouseExited

    private void b2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/consulter_hover.png"));
        b2.setIcon(II);
    }//GEN-LAST:event_b2MouseEntered

    private void b2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/consulter_default.png"));
        b2.setIcon(II);
    }//GEN-LAST:event_b2MouseExited

    private void b3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/inserer_hover.png"));
        b3.setIcon(II);
    }//GEN-LAST:event_b3MouseEntered

    private void b3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/inserer_default.png"));
        b3.setIcon(II);
    }//GEN-LAST:event_b3MouseExited

    private void b1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/creer_hover.png"));
        b1.setIcon(II);
    }//GEN-LAST:event_b1MouseEntered

    private void b1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/creer_default.png"));
        b1.setIcon(II);
    }//GEN-LAST:event_b1MouseExited

    private void b4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/attribuer1_hover.png"));
        b4.setIcon(II);
    }//GEN-LAST:event_b4MouseEntered

    private void b4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/attribuer1_default.png"));
        b4.setIcon(II);
    }//GEN-LAST:event_b4MouseExited

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
        Creer c = null;
        try {
            c = new Creer();
        } catch (DaoException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_b1MouseClicked

    private void b2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseClicked
        Consulte_planning cp = new Consulte_planning();
        cp.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_b2MouseClicked

    private void b3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseClicked
        ChoixF cf = null;
        try {
            cf = new ChoixF();
        } catch (DaoException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        cf.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_b3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b1;
    private javax.swing.JLabel b2;
    private javax.swing.JLabel b3;
    private javax.swing.JLabel b4;
    private javax.swing.JLabel b5;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel reduce;
    // End of variables declaration//GEN-END:variables
}
