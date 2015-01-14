

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aïssa
 */
public class ChoixF extends javax.swing.JFrame {

    /**
     * Creates new form ChoixF
     */
    public ChoixF() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTable1.setShowVerticalLines(false);
        jTable1.setColumnSelectionAllowed(false);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Film  1", "Column 2"});
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
        b3 = new javax.swing.JLabel();
        b2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        close = new javax.swing.JLabel();
        reduce = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(791, 578));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(791, 578));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/placer_default.png"))); // NOI18N
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
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 120, 50));

        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/afficherP_default.png"))); // NOI18N
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
        getContentPane().add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 170, 30));

        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/retourM_default.png"))); // NOI18N
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
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 170, 30));

        jLabel3.setText("Durée:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 73, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<15 min", "<30 min", "<45 min", "<60 min", "<90 min", ">90 min" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Long Métrage", "Court Métrage", "Un Certain Regard", "Hors Compétition" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        jLabel4.setText("Catégorie:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 73, -1, -1));

        jTextField1.setText("Rechercher un film");
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titre", "Durée (en min)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(170);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 320, 310));

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ChoixF.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void b1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/placer_hover.png"));
        b1.setIcon(II);
    }//GEN-LAST:event_b1MouseEntered

    private void b1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/placer_default.png"));
        b1.setIcon(II);
    }//GEN-LAST:event_b1MouseExited

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
        InsererF insF = new InsererF();
        insF.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_b1MouseClicked

    private void b2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseClicked
        Menu m = new Menu();
        m.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_b2MouseClicked

    private void b2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/retourM_hover.png"));
        b2.setIcon(II);
    }//GEN-LAST:event_b2MouseEntered

    private void b2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/retourM_default.png"));
        b2.setIcon(II);
    }//GEN-LAST:event_b2MouseExited

    private void b3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/afficherP_hover.png"));
        b3.setIcon(II);
    }//GEN-LAST:event_b3MouseEntered

    private void b3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/afficherP_default.png"));
        b3.setIcon(II);
    }//GEN-LAST:event_b3MouseExited

    private void b3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseClicked
        ProjectionP p = new ProjectionP();
        p.setVisible(rootPaneCheckingEnabled);
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
            java.util.logging.Logger.getLogger(ChoixF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChoixF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChoixF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChoixF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChoixF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b1;
    private javax.swing.JLabel b2;
    private javax.swing.JLabel b3;
    private javax.swing.JLabel close;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel reduce;
    // End of variables declaration//GEN-END:variables
}
