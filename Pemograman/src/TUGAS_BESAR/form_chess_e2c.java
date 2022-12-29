/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TUGAS_BESAR;

import java.awt.HeadlessException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;
import java.text.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.table.*;
import com.itextpdf.text.BaseColor;


/**
 *
 * @author ASUS
 */
public class form_chess_e2c extends javax.swing.JFrame {

    /**
     * Creates new form form_chess
     */
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Object set;
    
    public form_chess_e2c() {
        initComponents();
        
        tampilData();
        kosongkanData();
    }
    
    private void tampilData() {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Nomor Induk.");
        model.addColumn("Nama");
        model.addColumn("Nickname");
        model.addColumn("No. Wa");
        
        try {
            
            int No = 1;
            String sql = "SELECT * FROM chess_e2c";
            java.sql.Connection conn = (Connection) koneksi.getkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                model.addRow(new Object[]{No ++, res.getString(1), res.getString(2), res.getString(3),res.getString(4)});
                
            }
            TabelChess.setModel(model);
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        
    }
    
    private void ubahData() {
        String nama_player = txtNamaPlayer.getText();
        String nickname = txtNickname.getText();
        String no_wa = txtNoWAChess.getText();
    }
    
    private void kosongkanData() {
        txtNoInduk.setEditable(true);
        txtNoInduk.setText(null);
        txtNamaPlayer.setText(null);
        txtNickname.setText(null);
        txtNoWAChess.setText(null);
    }

    private void printPDF() {
        try {
            String nama = "D:\\Hasil Cetak\\data lomba chess e2c.pdf"; 
        
            //Document document = new Document();
            Document document = new Document(PageSize.A4); 
            
            koneksi koneksiDB = new koneksi();
            Connection conn = koneksiDB.getkoneksi();
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            PdfWriter.getInstance(document, new FileOutputStream(nama));
            document.open();
            
            String query = "SELECT * FROM chess_e2c";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            Paragraph paragraph1 = new Paragraph("Data Pendaftar Lomba Chess E2C");
            Paragraph paragraph2 = new Paragraph("==========================================================");
            Paragraph paragraph3 = new Paragraph("                                                            ");
            
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            
            // Membuat Tabel
            PdfPTable tablePDF = new PdfPTable(2);
            
            PdfPCell tableCell;
            
            tableCell = new PdfPCell(new Phrase("No. Induk "));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nama "));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
                     
            tableCell = new PdfPCell(new Phrase("Nickname"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            tableCell = new PdfPCell(new Phrase("No WA"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);

            while (rs.next()) {
                String NoInduk = rs.getString("Nomor_induk");
                tableCell = new PdfPCell(new Phrase(NoInduk));
                tablePDF.addCell(tableCell);

                String NamaPlayer = rs.getString("Nama_Player");
                tableCell = new PdfPCell(new Phrase(NamaPlayer));
                tablePDF.addCell(tableCell);

                String Nickname = rs.getString("Nickname");
                tableCell = new PdfPCell(new Phrase(Nickname));
                tablePDF.addCell(tableCell);

                String NoWA = rs.getString("Nomor_WhatsApp");
                tableCell = new PdfPCell(new Phrase(NoWA));
                tablePDF.addCell(tableCell);
                
            }
            
              
             //add image in pdf
            document.add(tablePDF);
             
            
            document.close();
        
            System.out.println("Finished");
            
            JOptionPane.showMessageDialog(null, "Dokumen telah dicetak !");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        PendaftaranMl = new javax.swing.JPanel();
        MobileLegends = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtNamaPlayer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNoWAChess = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSubmitML = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelChess = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        txtNoInduk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PendaftaranMl.setBackground(new java.awt.Color(202, 233, 255));
        PendaftaranMl.setPreferredSize(new java.awt.Dimension(820, 820));

        MobileLegends.setFont(new java.awt.Font("Poppins ExtraBold", 0, 24)); // NOI18N
        MobileLegends.setForeground(new java.awt.Color(27, 73, 101));
        MobileLegends.setText("CHESS E2C");
        MobileLegends.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setBackground(new java.awt.Color(202, 233, 255));

        txtNamaPlayer.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayer.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 73, 101));
        jLabel3.setText("Nickname");

        txtNickname.setBackground(new java.awt.Color(95, 168, 211));
        txtNickname.setForeground(new java.awt.Color(255, 255, 255));
        txtNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 73, 101));
        jLabel4.setText("Nomor WhatsApp");

        txtNoWAChess.setBackground(new java.awt.Color(95, 168, 211));
        txtNoWAChess.setForeground(new java.awt.Color(255, 255, 255));
        txtNoWAChess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoWAChessActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 73, 101));
        jLabel2.setText("Nama Player");

        btnSubmitML.setBackground(new java.awt.Color(98, 182, 203));
        btnSubmitML.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        btnSubmitML.setForeground(new java.awt.Color(27, 73, 101));
        btnSubmitML.setText("Submit");
        btnSubmitML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitMLActionPerformed(evt);
            }
        });

        TabelChess.setBackground(new java.awt.Color(95, 168, 211));
        TabelChess.setForeground(new java.awt.Color(255, 255, 255));
        TabelChess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No", "Nama_Team"
            }
        ));
        TabelChess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelChessMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelChess);

        btnUpdate.setBackground(new java.awt.Color(95, 168, 211));
        btnUpdate.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(27, 73, 101));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtNoInduk.setBackground(new java.awt.Color(95, 168, 211));
        txtNoInduk.setForeground(new java.awt.Color(255, 255, 255));
        txtNoInduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoIndukActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 73, 101));
        jLabel5.setText("Nomor Induk");

        btnDelete.setBackground(new java.awt.Color(95, 168, 211));
        btnDelete.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(27, 73, 101));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        Print.setBackground(new java.awt.Color(95, 168, 211));
        Print.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        Print.setForeground(new java.awt.Color(27, 73, 101));
        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaPlayer)
                    .addComponent(txtNickname)
                    .addComponent(txtNoWAChess)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addComponent(txtNoInduk)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmitML, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoWAChess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitML)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(Print))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(95, 168, 211));
        jButton2.setFont(new java.awt.Font("Poppins ExtraBold", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(27, 73, 101));
        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PendaftaranMlLayout = new javax.swing.GroupLayout(PendaftaranMl);
        PendaftaranMl.setLayout(PendaftaranMlLayout);
        PendaftaranMlLayout.setHorizontalGroup(
            PendaftaranMlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PendaftaranMlLayout.createSequentialGroup()
                .addGroup(PendaftaranMlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PendaftaranMlLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton2))
                    .addGroup(PendaftaranMlLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PendaftaranMlLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(MobileLegends)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        PendaftaranMlLayout.setVerticalGroup(
            PendaftaranMlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PendaftaranMlLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(MobileLegends)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(293, 293, 293))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PendaftaranMl, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PendaftaranMl, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitMLActionPerformed
        // TODO add your handling code here:
        conn = (Connection) koneksi.getkoneksi();

        try {
            
            String sql = "INSERT INTO chess_e2c VALUES('"+ txtNoInduk.getText() + "','"+ txtNamaPlayer.getText() + "','" + txtNickname.getText() + "','" + txtNoWAChess.getText() + "')";
             
            java.sql.Connection conn = (java.sql.Connection) koneksi.getkoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();

            tampilData();
            
            JOptionPane.showMessageDialog(null, "Data Tersimpan");

            
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        kosongkanData();
        
       
    }//GEN-LAST:event_btnSubmitMLActionPerformed

    private void txtNoWAChessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoWAChessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoWAChessActionPerformed

    private void txtNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknameActionPerformed

    private void txtNamaPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Chess chess = new Chess();
        chess.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        
        try {
            
            String sql = "UPDATE chess_e2c set Nomor_induk = '"+ txtNoInduk.getText() +"', Nama_Player = '"+ txtNamaPlayer.getText() + "', Nickname = '" + txtNickname.getText() + "', Nomor_WhatsApp = '" + txtNoWAChess.getText() + "' WHERE Nomor_induk = '" + txtNoInduk.getText() + "'";
             
            java.sql.Connection conn = (java.sql.Connection) koneksi.getkoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Update Data Berhasil");

            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilData();
        kosongkanData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void TabelChessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelChessMouseClicked
        // TODO add your handling code here:
        int baris = TabelChess.rowAtPoint(evt.getPoint());
        
        String Nomor_induk = TabelChess.getValueAt(baris, 1).toString();
        txtNoInduk.setText(Nomor_induk);
        
        String nama_player = TabelChess.getValueAt(baris, 2).toString();
        txtNamaPlayer.setText(nama_player);

        String nickname = TabelChess.getValueAt(baris, 3).toString();
        txtNickname.setText(nickname);
        
        String no_wa = TabelChess.getValueAt(baris, 4).toString();
        txtNoWAChess.setText(no_wa);
        
    }//GEN-LAST:event_TabelChessMouseClicked

    private void txtNoIndukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoIndukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoIndukActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM chess_e2c WHERE Nomor_induk='"+txtNoInduk.getText()+"'";
            
             
            java.sql.Connection conn = (java.sql.Connection) koneksi.getkoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");

            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilData();
        kosongkanData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        // TODO add your handling code here:
        printPDF();
    }//GEN-LAST:event_PrintActionPerformed

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
            java.util.logging.Logger.getLogger(form_chess_e2c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_chess_e2c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_chess_e2c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_chess_e2c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_chess_e2c().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MobileLegends;
    private javax.swing.JPanel PendaftaranMl;
    private javax.swing.JButton Print;
    private javax.swing.JTable TabelChess;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSubmitML;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNamaPlayer;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNoInduk;
    private javax.swing.JTextField txtNoWAChess;
    // End of variables declaration//GEN-END:variables
}
