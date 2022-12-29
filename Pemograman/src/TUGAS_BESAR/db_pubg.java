/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TUGAS_BESAR;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ASUS
 */
public class db_pubg extends javax.swing.JFrame {

   Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Object set;

    public db_pubg() {
        initComponents();
        tampilData1();
        tampilData2();
        tampilData3();
    }

     private void tampilData1() {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Nomor Induk.");
        model.addColumn("Nama Team");
        model.addColumn("Nama Leader");
        model.addColumn("No. Wa");
        model.addColumn("Player 1");
        model.addColumn("Nickname P1");
        model.addColumn("ID P1");
        model.addColumn("Player 2");
        model.addColumn("Nickname P2");
        model.addColumn("ID P2");
        model.addColumn("Player 3");
        model.addColumn("Nickname P3");
        model.addColumn("ID P3");
        model.addColumn("Player 4");
        model.addColumn("Nickname P4");
        model.addColumn("ID P4");
        
        try {
            
            int No = 1;
            String sql = "SELECT * FROM pubg_rektorcup";
            java.sql.Connection conn = (Connection) koneksi.getkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                model.addRow(new Object[]{No ++, res.getString(1), res.getString(2), res.getString(3),res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8), res.getString(9), res.getString(10), res.getString(11),res.getString(12), res.getString(13), res.getString(14), res.getString(15),res.getString(16)});
                
                
            }
            tablePUBG_rektor.setModel(model);
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        
     }
     private void tampilData2() {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Nomor Induk.");
        model.addColumn("Nama Team");
        model.addColumn("Nama Leader");
        model.addColumn("No. Wa");
        model.addColumn("Player 1");
        model.addColumn("Nickname P1");
        model.addColumn("ID P1");
        model.addColumn("Player 2");
        model.addColumn("Nickname P2");
        model.addColumn("ID P2");
        model.addColumn("Player 3");
        model.addColumn("Nickname P3");
        model.addColumn("ID P3");
        model.addColumn("Player 4");
        model.addColumn("Nickname P4");
        model.addColumn("ID P4");
        
        try {
            
            int No = 1;
            String sql = "SELECT * FROM pubg_e2c";
            java.sql.Connection conn = (Connection) koneksi.getkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                model.addRow(new Object[]{No ++, res.getString(1), res.getString(2), res.getString(3),res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8), res.getString(9), res.getString(10), res.getString(11),res.getString(12), res.getString(13), res.getString(14), res.getString(15),res.getString(16)});
                
                
            }
            tablePUBG_e2c.setModel(model);
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        
     }
     private void tampilData3() {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Nomor Induk.");
        model.addColumn("Nama Team");
        model.addColumn("Nama Leader");
        model.addColumn("No. Wa");
        model.addColumn("Player 1");
        model.addColumn("Nickname P1");
        model.addColumn("ID P1");
        model.addColumn("Player 2");
        model.addColumn("Nickname P2");
        model.addColumn("ID P2");
        model.addColumn("Player 3");
        model.addColumn("Nickname P3");
        model.addColumn("ID P3");
        model.addColumn("Player 4");
        model.addColumn("Nickname P4");
        model.addColumn("ID P4");
        
        try {
            
            int No = 1;
            String sql = "SELECT * FROM pubg_itcontest";
            java.sql.Connection conn = (Connection) koneksi.getkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                model.addRow(new Object[]{No ++, res.getString(1), res.getString(2), res.getString(3),res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8), res.getString(9), res.getString(10), res.getString(11),res.getString(12), res.getString(13), res.getString(14), res.getString(15),res.getString(16)});
                
                
            }
            tablePUBG_itcon.setModel(model);
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        
     }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePUBG_e2c = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePUBG_rektor = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePUBG_itcon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(202, 233, 255));

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 73, 101));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("- DATABASE -");

        jButton7.setBackground(new java.awt.Color(95, 168, 211));
        jButton7.setFont(new java.awt.Font("Poppins ExtraBold", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(27, 73, 101));
        jButton7.setText("<");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        tablePUBG_e2c.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Team", "leader", "No Hp", "Player 1", "NickName", "Id", "Player 2", "NickName", "Id", "Player 3", "NickName", "Id", "Player 4", "NickName", "Id"
            }
        ));
        jScrollPane1.setViewportView(tablePUBG_e2c);
        if (tablePUBG_e2c.getColumnModel().getColumnCount() > 0) {
            tablePUBG_e2c.getColumnModel().getColumn(1).setHeaderValue("");
            tablePUBG_e2c.getColumnModel().getColumn(4).setHeaderValue("NickName");
            tablePUBG_e2c.getColumnModel().getColumn(5).setHeaderValue("Id");
            tablePUBG_e2c.getColumnModel().getColumn(6).setHeaderValue("Player 2");
            tablePUBG_e2c.getColumnModel().getColumn(7).setHeaderValue("NickName");
            tablePUBG_e2c.getColumnModel().getColumn(8).setHeaderValue("Id");
            tablePUBG_e2c.getColumnModel().getColumn(9).setHeaderValue("Player 3");
            tablePUBG_e2c.getColumnModel().getColumn(10).setHeaderValue("NickName");
            tablePUBG_e2c.getColumnModel().getColumn(11).setHeaderValue("Id");
            tablePUBG_e2c.getColumnModel().getColumn(12).setHeaderValue("Player 4");
            tablePUBG_e2c.getColumnModel().getColumn(13).setHeaderValue("NickName");
            tablePUBG_e2c.getColumnModel().getColumn(14).setHeaderValue("Id");
        }

        tablePUBG_rektor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Team", "leader", "No Hp", "Player 1", "NickName", "Id", "Player 2", "NickName", "Id", "Player 3", "NickName", "Id", "Player 4", "NickName", "Id"
            }
        ));
        jScrollPane2.setViewportView(tablePUBG_rektor);
        if (tablePUBG_rektor.getColumnModel().getColumnCount() > 0) {
            tablePUBG_rektor.getColumnModel().getColumn(1).setHeaderValue("");
            tablePUBG_rektor.getColumnModel().getColumn(4).setHeaderValue("NickName");
            tablePUBG_rektor.getColumnModel().getColumn(5).setHeaderValue("Id");
            tablePUBG_rektor.getColumnModel().getColumn(6).setHeaderValue("Player 2");
            tablePUBG_rektor.getColumnModel().getColumn(7).setHeaderValue("NickName");
            tablePUBG_rektor.getColumnModel().getColumn(8).setHeaderValue("Id");
            tablePUBG_rektor.getColumnModel().getColumn(9).setHeaderValue("Player 3");
            tablePUBG_rektor.getColumnModel().getColumn(10).setHeaderValue("NickName");
            tablePUBG_rektor.getColumnModel().getColumn(11).setHeaderValue("Id");
            tablePUBG_rektor.getColumnModel().getColumn(12).setHeaderValue("Player 4");
            tablePUBG_rektor.getColumnModel().getColumn(13).setHeaderValue("NickName");
            tablePUBG_rektor.getColumnModel().getColumn(14).setHeaderValue("Id");
        }

        tablePUBG_itcon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Team", "leader", "No Hp", "Player 1", "NickName", "Id", "Player 2", "NickName", "Id", "Player 3", "NickName", "Id", "Player 4", "NickName", "Id"
            }
        ));
        jScrollPane3.setViewportView(tablePUBG_itcon);
        if (tablePUBG_itcon.getColumnModel().getColumnCount() > 0) {
            tablePUBG_itcon.getColumnModel().getColumn(1).setHeaderValue("");
            tablePUBG_itcon.getColumnModel().getColumn(4).setHeaderValue("NickName");
            tablePUBG_itcon.getColumnModel().getColumn(5).setHeaderValue("Id");
            tablePUBG_itcon.getColumnModel().getColumn(6).setHeaderValue("Player 2");
            tablePUBG_itcon.getColumnModel().getColumn(7).setHeaderValue("NickName");
            tablePUBG_itcon.getColumnModel().getColumn(8).setHeaderValue("Id");
            tablePUBG_itcon.getColumnModel().getColumn(9).setHeaderValue("Player 3");
            tablePUBG_itcon.getColumnModel().getColumn(10).setHeaderValue("NickName");
            tablePUBG_itcon.getColumnModel().getColumn(11).setHeaderValue("Id");
            tablePUBG_itcon.getColumnModel().getColumn(12).setHeaderValue("Player 4");
            tablePUBG_itcon.getColumnModel().getColumn(13).setHeaderValue("NickName");
            tablePUBG_itcon.getColumnModel().getColumn(14).setHeaderValue("Id");
        }

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 73, 101));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PUBG E2C");

        jLabel.setFont(new java.awt.Font("Poppins ExtraBold", 0, 18)); // NOI18N
        jLabel.setForeground(new java.awt.Color(27, 73, 101));
        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("PUBG IT Contest");

        jLabel4.setFont(new java.awt.Font("Poppins ExtraBold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 73, 101));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PUBG Rektor Cup");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton7)
                .addGap(335, 335, 335)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(334, 334, 334))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(358, 358, 358))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(322, 322, 322))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        database db = new database();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(db_pubg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(db_pubg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(db_pubg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(db_pubg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new db_pubg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablePUBG_e2c;
    private javax.swing.JTable tablePUBG_itcon;
    private javax.swing.JTable tablePUBG_rektor;
    // End of variables declaration//GEN-END:variables
}
