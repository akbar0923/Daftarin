/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TUGAS_BESAR;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class form_pubg_itcontest extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Object set;

    public form_pubg_itcontest() {
        initComponents();
        tampilData();
        kosongkanData();
    }
    
    private void tampilData() {
        
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
            tablePUBGM.setModel(model);
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        
     }

    private void ubahData() {
        String namaTeam = txtNamaTeamPUBG.getText();
        String namaLeader = txtNamaLeaderPUBG.getText();
        String no_wa = txtNoWAPUBG.getText();
        String player1 =txtNamaPlayerPUBG1.getText();
        String nickname1 = txtNickPUBG1.getText();
        String id1 = txtIDPUBG1.getText();
        String player2 =txtNamaPlayerPUBG2.getText();
        String nickname2 = txtNickPUBG2.getText();
        String id2 = txtIDPUBG2.getText();
        String player3 =txtNamaPlayerPUBG3.getText();
        String nickname3 = txtNickPUBG3.getText();
        String id3 = txtIDPUBG3.getText();
        String player4 =txtNamaPlayerPUBG4.getText();
        String nickname4 = txtNickPUBG4.getText();
        String id4 = txtIDPUBG4.getText();
        
    }
    
    private void kosongkanData() {
        txtNoInduk.setEditable(true);
        txtNoInduk.setText(null);
        txtNamaTeamPUBG.setText(null);
        txtNamaLeaderPUBG.setText(null);
        txtNoWAPUBG.setText(null);
        txtNamaPlayerPUBG1.setText(null);
        txtNickPUBG1.setText(null);
        txtIDPUBG1.setText(null);
        txtNamaPlayerPUBG2.setText(null);
        txtNickPUBG2.setText(null);
        txtIDPUBG2.setText(null);
        txtNamaPlayerPUBG3.setText(null);
        txtNickPUBG3.setText(null);
        txtIDPUBG3.setText(null);
        txtNamaPlayerPUBG4.setText(null);
        txtNickPUBG4.setText(null);
        txtIDPUBG4.setText(null);
        
    }

    private void printPDF() {
        try {
            String nama = "D:\\Hasil Cetak\\Data Lomba PUBGM IT CONTEST.pdf"; 
        
            Document document = new Document(PageSize.A4.rotate(), 10f, 10f, 100f, 0f); 
            
            koneksi koneksiDB = new koneksi();
            Connection conn = koneksiDB.getkoneksi();
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            PdfWriter.getInstance(document, new FileOutputStream(nama));
            document.open();
            
            String query = "SELECT * FROM pubg_itcontest";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            Paragraph paragraph1 = new Paragraph("Data Pendaftar Lomba PUBG Mobile IT CONTEST");
            Paragraph paragraph2 = new Paragraph("==========================================================");
            Paragraph paragraph3 = new Paragraph("                                                            ");
            
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            
            // Membuat Tabel
            PdfPTable tablePDF = new PdfPTable(16);
            
            PdfPCell tableCell;
            
            tableCell = new PdfPCell(new Phrase("No. Induk "));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nama Team "));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);

                     
            tableCell = new PdfPCell(new Phrase("Nama Leader"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("No WA"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nama Player 1"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nickname 1"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("ID P1"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nama Player 2"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nickname 2"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("ID P2"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nama Player 3"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nickname 3"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("ID P3"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nama Player 4"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nickname 4"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("ID P4"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            
            while (rs.next()) {
                String NoInduk = rs.getString("Nomor_induk");
                tableCell = new PdfPCell(new Phrase(NoInduk));
                tablePDF.addCell(tableCell);

                String NamaTeam = rs.getString("Nama_Team");
                tableCell = new PdfPCell(new Phrase(NamaTeam));
                tablePDF.addCell(tableCell);

                String NamaLeader = rs.getString("Nama_Leader");
                tableCell = new PdfPCell(new Phrase(NamaLeader));
                tablePDF.addCell(tableCell);

                String NoWA = rs.getString("No_Wa");
                tableCell = new PdfPCell(new Phrase(NoWA));
                tablePDF.addCell(tableCell);
                
                String Player1 = rs.getString("Player1");
                tableCell = new PdfPCell(new Phrase(Player1));
                tablePDF.addCell(tableCell);

                String Nickname1 = rs.getString("Nickname1");
                tableCell = new PdfPCell(new Phrase(Nickname1));
                tablePDF.addCell(tableCell);

                String Id1 = rs.getString("Id1");
                tableCell = new PdfPCell(new Phrase(Id1));
                tablePDF.addCell(tableCell);
                
            String Player2 = rs.getString("Player2");
            tableCell = new PdfPCell(new Phrase(Player2));
            tablePDF.addCell(tableCell);

            String Nickname2 = rs.getString("Nickname2");
            tableCell = new PdfPCell(new Phrase(Nickname2));
            tablePDF.addCell(tableCell);

            String Id2 = rs.getString("Id2");
            tableCell = new PdfPCell(new Phrase(Id2));
            tablePDF.addCell(tableCell);
            
            String Player3 = rs.getString("Player3");
            tableCell = new PdfPCell(new Phrase(Player3));
            tablePDF.addCell(tableCell);

            String Nickname3 = rs.getString("Nickname3");
            tableCell = new PdfPCell(new Phrase(Nickname3));
            tablePDF.addCell(tableCell);

            String Id3 = rs.getString("Id3");
            tableCell = new PdfPCell(new Phrase(Id3));
            tablePDF.addCell(tableCell);
            
            String Player4 = rs.getString("Player4");
            tableCell = new PdfPCell(new Phrase(Player4));
            tablePDF.addCell(tableCell);

            String Nickname4 = rs.getString("Nickname4");
            tableCell = new PdfPCell(new Phrase(Nickname4));
            tablePDF.addCell(tableCell);

            String Id4 = rs.getString("Id4");
            tableCell = new PdfPCell(new Phrase(Id4));
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePUBGM = new javax.swing.JTable();
        Scrollbar = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNamaTeamPUBG = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNamaLeaderPUBG = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNoWAPUBG = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNamaPlayerPUBG1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNickPUBG1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIDPUBG1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNamaPlayerPUBG2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNickPUBG2 = new javax.swing.JTextField();
        txtIDPUBG2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNamaPlayerPUBG3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNickPUBG3 = new javax.swing.JTextField();
        txtIDPUBG3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNamaPlayerPUBG4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNickPUBG4 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIDPUBG4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNoInduk = new javax.swing.JTextField();
        btnSubmitDataPUBG = new javax.swing.JToggleButton();
        btnUpdate = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No", "Nama Team"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(202, 233, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 25));

        jPanel2.setBackground(new java.awt.Color(202, 233, 255));

        tablePUBGM.setBackground(new java.awt.Color(95, 168, 211));
        tablePUBGM.setForeground(new java.awt.Color(202, 233, 255));
        tablePUBGM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No", "Nama Team"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablePUBGM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePUBGMMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablePUBGM);

        Scrollbar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        Scrollbar.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel3.setBackground(new java.awt.Color(202, 233, 255));

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 73, 101));
        jLabel2.setText("Nama Team");

        txtNamaTeamPUBG.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaTeamPUBG.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaTeamPUBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaTeamPUBGActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 73, 101));
        jLabel3.setText("Leader");

        txtNamaLeaderPUBG.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaLeaderPUBG.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaLeaderPUBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaLeaderPUBGActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 73, 101));
        jLabel4.setText("Nomor WhatsApp");

        txtNoWAPUBG.setBackground(new java.awt.Color(95, 168, 211));
        txtNoWAPUBG.setForeground(new java.awt.Color(255, 255, 255));
        txtNoWAPUBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoWAPUBGActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 73, 101));
        jLabel5.setText("Player 1");

        txtNamaPlayerPUBG1.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayerPUBG1.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayerPUBG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerPUBG1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 73, 101));
        jLabel6.setText("NickName");

        txtNickPUBG1.setBackground(new java.awt.Color(95, 168, 211));
        txtNickPUBG1.setForeground(new java.awt.Color(255, 255, 255));
        txtNickPUBG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickPUBG1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 73, 101));
        jLabel7.setText("Id Player");

        txtIDPUBG1.setBackground(new java.awt.Color(95, 168, 211));
        txtIDPUBG1.setForeground(new java.awt.Color(255, 255, 255));
        txtIDPUBG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPUBG1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 73, 101));
        jLabel8.setText("Player 2");

        txtNamaPlayerPUBG2.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayerPUBG2.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayerPUBG2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerPUBG2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(27, 73, 101));
        jLabel9.setText("NickName");

        txtNickPUBG2.setBackground(new java.awt.Color(95, 168, 211));
        txtNickPUBG2.setForeground(new java.awt.Color(255, 255, 255));
        txtNickPUBG2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickPUBG2ActionPerformed(evt);
            }
        });

        txtIDPUBG2.setBackground(new java.awt.Color(95, 168, 211));
        txtIDPUBG2.setForeground(new java.awt.Color(255, 255, 255));
        txtIDPUBG2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPUBG2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 73, 101));
        jLabel10.setText("Id Player");

        jLabel11.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 73, 101));
        jLabel11.setText("Player 3");

        txtNamaPlayerPUBG3.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayerPUBG3.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayerPUBG3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerPUBG3ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 73, 101));
        jLabel12.setText("NickName");

        txtNickPUBG3.setBackground(new java.awt.Color(95, 168, 211));
        txtNickPUBG3.setForeground(new java.awt.Color(255, 255, 255));
        txtNickPUBG3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickPUBG3ActionPerformed(evt);
            }
        });

        txtIDPUBG3.setBackground(new java.awt.Color(95, 168, 211));
        txtIDPUBG3.setForeground(new java.awt.Color(255, 255, 255));
        txtIDPUBG3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPUBG3ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 73, 101));
        jLabel13.setText("Id Player");

        jLabel14.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(27, 73, 101));
        jLabel14.setText("Player 4");

        txtNamaPlayerPUBG4.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayerPUBG4.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayerPUBG4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerPUBG4ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(27, 73, 101));
        jLabel15.setText("NickName");

        txtNickPUBG4.setBackground(new java.awt.Color(95, 168, 211));
        txtNickPUBG4.setForeground(new java.awt.Color(255, 255, 255));
        txtNickPUBG4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickPUBG4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(27, 73, 101));
        jLabel16.setText("Id Player");

        txtIDPUBG4.setBackground(new java.awt.Color(95, 168, 211));
        txtIDPUBG4.setForeground(new java.awt.Color(255, 255, 255));
        txtIDPUBG4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPUBG4ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 73, 101));
        jLabel17.setText("Nomor Induk");

        txtNoInduk.setBackground(new java.awt.Color(95, 168, 211));
        txtNoInduk.setForeground(new java.awt.Color(255, 255, 255));
        txtNoInduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoIndukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDPUBG4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNickPUBG4)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPlayerPUBG4)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDPUBG3)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNickPUBG3)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPlayerPUBG3)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDPUBG2)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNickPUBG2)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPlayerPUBG2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDPUBG1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNickPUBG1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPlayerPUBG1)
                    .addComponent(jLabel2)
                    .addComponent(txtNamaTeamPUBG)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaLeaderPUBG)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoWAPUBG)
                    .addComponent(txtNoInduk))
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaTeamPUBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaLeaderPUBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoWAPUBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayerPUBG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickPUBG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDPUBG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayerPUBG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickPUBG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDPUBG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayerPUBG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickPUBG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDPUBG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayerPUBG4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickPUBG4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDPUBG4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Scrollbar.setViewportView(jPanel3);

        btnSubmitDataPUBG.setBackground(new java.awt.Color(98, 182, 203));
        btnSubmitDataPUBG.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        btnSubmitDataPUBG.setForeground(new java.awt.Color(27, 73, 101));
        btnSubmitDataPUBG.setText("Submit");
        btnSubmitDataPUBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitDataPUBGActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(95, 168, 211));
        btnUpdate.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(27, 73, 101));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(95, 168, 211));
        btnPrint.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(27, 73, 101));
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(95, 168, 211));
        btnDelete.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(27, 73, 101));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmitDataPUBG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Scrollbar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(Scrollbar, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnSubmitDataPUBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrint)
                    .addComponent(btnDelete))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jPanel6.setBackground(new java.awt.Color(202, 233, 255));

        jButton2.setBackground(new java.awt.Color(95, 168, 211));
        jButton2.setFont(new java.awt.Font("Poppins ExtraBold", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(27, 73, 101));
        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 73, 101));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PUBG MOBILE IT CONTEST");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton2)
                .addGap(180, 180, 180)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitDataPUBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitDataPUBGActionPerformed
        conn = (Connection) koneksi.getkoneksi();

        try {
            
            String sql = "INSERT INTO pubg_itcontest VALUES('" + txtNoInduk.getText() + "','" + txtNamaTeamPUBG.getText() + "','" + txtNamaLeaderPUBG.getText() + "','" + txtNoWAPUBG.getText() + "','" + txtNamaPlayerPUBG1.getText() + "','" + txtNickPUBG1.getText() + "','" + txtIDPUBG1.getText() + "','" + txtNamaPlayerPUBG2.getText() + "','" + txtNickPUBG2.getText() + "','" + txtIDPUBG2.getText()
                    + "','" + txtNamaPlayerPUBG3.getText() + "','" + txtNickPUBG3.getText() + "','" + txtIDPUBG3.getText() + "','" + txtNamaPlayerPUBG4.getText() + "','" + txtNickPUBG4.getText() + "','" + txtIDPUBG4.getText() + "')";
            
            java.sql.Connection conn = (java.sql.Connection) koneksi.getkoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();

            tampilData();
            kosongkanData();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");

            
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_btnSubmitDataPUBGActionPerformed

    private void txtIDPUBG4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPUBG4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPUBG4ActionPerformed

    private void txtNickPUBG4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickPUBG4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickPUBG4ActionPerformed

    private void txtNamaPlayerPUBG4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerPUBG4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerPUBG4ActionPerformed

    private void txtIDPUBG3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPUBG3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPUBG3ActionPerformed

    private void txtNickPUBG3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickPUBG3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickPUBG3ActionPerformed

    private void txtNamaPlayerPUBG3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerPUBG3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerPUBG3ActionPerformed

    private void txtIDPUBG2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPUBG2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPUBG2ActionPerformed

    private void txtNickPUBG2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickPUBG2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickPUBG2ActionPerformed

    private void txtNamaPlayerPUBG2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerPUBG2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerPUBG2ActionPerformed

    private void txtIDPUBG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPUBG1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPUBG1ActionPerformed

    private void txtNickPUBG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickPUBG1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickPUBG1ActionPerformed

    private void txtNamaPlayerPUBG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerPUBG1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerPUBG1ActionPerformed

    private void txtNoWAPUBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoWAPUBGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoWAPUBGActionPerformed

    private void txtNamaLeaderPUBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaLeaderPUBGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaLeaderPUBGActionPerformed

    private void txtNamaTeamPUBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaTeamPUBGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaTeamPUBGActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PUBGM pubgm = new PUBGM();
        pubgm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablePUBGMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePUBGMMouseClicked
        // TODO add your handling code here:
        int baris = tablePUBGM.rowAtPoint(evt.getPoint());

        String Nomor_induk = tablePUBGM.getValueAt(baris, 1).toString();
        txtNoInduk.setText(Nomor_induk);

        String nama_Team = tablePUBGM.getValueAt(baris, 2).toString();
        txtNamaTeamPUBG.setText(nama_Team);

        String Leader = tablePUBGM.getValueAt(baris, 3).toString();
        txtNamaLeaderPUBG.setText(Leader);

        String no_wa = tablePUBGM.getValueAt(baris, 4).toString();
        txtNoWAPUBG.setText(no_wa);

        String Player1 = tablePUBGM.getValueAt(baris, 5).toString();
        txtNamaPlayerPUBG1.setText(Player1);

        String nick1 = tablePUBGM.getValueAt(baris, 6).toString();
        txtNickPUBG1.setText(nick1);

        String id1 = tablePUBGM.getValueAt(baris, 7).toString();
        txtIDPUBG1.setText(id1);

        String Player2 = tablePUBGM.getValueAt(baris, 8).toString();
        txtNamaPlayerPUBG2.setText(Player2);

        String nick2 = tablePUBGM.getValueAt(baris, 9).toString();
        txtNickPUBG2.setText(nick2);

        String id2 = tablePUBGM.getValueAt(baris, 10).toString();
        txtIDPUBG2.setText(id2);

        String Player3 = tablePUBGM.getValueAt(baris, 11).toString();
        txtNamaPlayerPUBG3.setText(Player3);

        String nick3 = tablePUBGM.getValueAt(baris, 12).toString();
        txtNickPUBG3.setText(nick3);

        String id3 = tablePUBGM.getValueAt(baris, 13).toString();
        txtIDPUBG3.setText(id3);

        String Player4 = tablePUBGM.getValueAt(baris, 14).toString();
        txtNamaPlayerPUBG4.setText(Player4);

        String nick4 = tablePUBGM.getValueAt(baris, 15).toString();
        txtNickPUBG4.setText(nick4);

        String id4 = tablePUBGM.getValueAt(baris, 16).toString();
        txtIDPUBG4.setText(id4);

    }//GEN-LAST:event_tablePUBGMMouseClicked

    private void txtNoIndukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoIndukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoIndukActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            
            String sql = "UPDATE PUBG_itcontest set Nomor_induk = '"+ txtNoInduk.getText() +"', Nama_Team = '"+ txtNamaTeamPUBG.getText() + "', Nama_Leader = '" + txtNamaLeaderPUBG.getText() + "', No_Wa = '" + txtNoWAPUBG.getText() 
                    + "', Player1 = '"+ txtNamaPlayerPUBG1.getText() + "', Nickname1 = '" + txtNickPUBG1.getText() + "', Id1 = '" + txtIDPUBG1.getText()
                    + "', Player2 = '"+ txtNamaPlayerPUBG2.getText() + "', Nickname2 = '" + txtNickPUBG2.getText() + "', Id2 = '" + txtIDPUBG2.getText()
                    + "', Player3 = '"+ txtNamaPlayerPUBG3.getText() + "', Nickname3 = '" + txtNickPUBG3.getText() + "', Id3 = '" + txtIDPUBG3.getText()
                    + "', Player4 = '"+ txtNamaPlayerPUBG4.getText() + "', Nickname4 = '" + txtNickPUBG4.getText() + "', Id4 = '" + txtIDPUBG4.getText()
                    + "' WHERE Nomor_induk = '" + txtNoInduk.getText() + "'";
             
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

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        printPDF();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
        String sql = "DELETE FROM pubg_itcontest WHERE Nomor_induk='"+txtNoInduk.getText()+"'";
            
             
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
            java.util.logging.Logger.getLogger(form_pubg_itcontest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_pubg_itcontest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_pubg_itcontest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_pubg_itcontest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_pubg_itcontest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scrollbar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JToggleButton btnSubmitDataPUBG;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablePUBGM;
    private javax.swing.JTextField txtIDPUBG1;
    private javax.swing.JTextField txtIDPUBG2;
    private javax.swing.JTextField txtIDPUBG3;
    private javax.swing.JTextField txtIDPUBG4;
    private javax.swing.JTextField txtNamaLeaderPUBG;
    private javax.swing.JTextField txtNamaPlayerPUBG1;
    private javax.swing.JTextField txtNamaPlayerPUBG2;
    private javax.swing.JTextField txtNamaPlayerPUBG3;
    private javax.swing.JTextField txtNamaPlayerPUBG4;
    private javax.swing.JTextField txtNamaTeamPUBG;
    private javax.swing.JTextField txtNickPUBG1;
    private javax.swing.JTextField txtNickPUBG2;
    private javax.swing.JTextField txtNickPUBG3;
    private javax.swing.JTextField txtNickPUBG4;
    private javax.swing.JTextField txtNoInduk;
    private javax.swing.JTextField txtNoWAPUBG;
    // End of variables declaration//GEN-END:variables
}
