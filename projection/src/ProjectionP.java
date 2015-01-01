

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import projection.DaoCreneau;
import projection.DaoException;
import projection.DaoProjection;
import projection.DaoSalle;
import projection.DaoType;
import projection.Film;
import projection.Projection;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aïssa
 */
public class ProjectionP extends javax.swing.JFrame {

    /**
     * Creates new form ProjectionP
     * @param titre
     */
    public ProjectionP(String titre) throws DaoException {
        initComponents();
        this.setLocationRelativeTo(null);
        DaoProjection daoP = DaoProjection.getDAO();
        
        Collection <Projection> col = new ArrayList();
        col = daoP.ProjectionPrevues(titre);
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        DaoSalle daoS = DaoSalle.getDAO();
        DaoType daoT = DaoType.getDAO();
        DaoCreneau daoC = DaoCreneau.getDAO();
        
        for (Projection p : col) {
                model.addRow(new Object[]{daoT.nomType(p.getId_type()),daoC.date(p.getId_premier_creneau()),
                daoC.heureDebut(p.getId_premier_creneau()),daoS.nomSalle(p.getId_salle())});
            }
    }

    private ProjectionP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b1 = new javax.swing.JLabel();
        reduce = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(560, 314));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(560, 314));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/retour2_default.png"))); // NOI18N
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
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 90, 30));

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
        getContentPane().add(reduce, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 20, 20));

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
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 5, 20, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type de projection", "Date", "Heure", "Salle"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ProjectionP.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 560));

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
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/fermer_hover.png"));
        close.setIcon(II);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/fermer_default.png"));
        close.setIcon(II);
    }//GEN-LAST:event_closeMouseExited

    private void b1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/retour2_hover.png"));
        b1.setIcon(II);
    }//GEN-LAST:event_b1MouseEntered

    private void b1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/retour2_default.png"));
        b1.setIcon(II);
    }//GEN-LAST:event_b1MouseExited

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
        this.dispose();
    }//GEN-LAST:event_b1MouseClicked

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
            java.util.logging.Logger.getLogger(ProjectionP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectionP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectionP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectionP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectionP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b1;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel reduce;
    // End of variables declaration//GEN-END:variables
}
