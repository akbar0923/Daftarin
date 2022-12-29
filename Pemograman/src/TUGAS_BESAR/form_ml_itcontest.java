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
import java.awt.print.PageFormat;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class form_ml_itcontest extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Object set;

    public form_ml_itcontest() {
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
        model.addColumn("Player 5");
        model.addColumn("Nickname P5");
        model.addColumn("ID P5");
        
        try {
            
            int No = 1;
            String sql = "SELECT * FROM ml_itcontest";
            java.sql.Connection conn = (Connection) koneksi.getkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                model.addRow(new Object[]{No ++, res.getString(1), res.getString(2), res.getString(3),res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8), res.getString(9), res.getString(10), res.getString(11),res.getString(12), res.getString(13), res.getString(14), res.getString(15),res.getString(16), res.getString(17), res.getString(18), res.getString(19)});
                
                
            }
            tableML.setModel(model);
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        
     }
     
    private void ubahData() {
        String namaTeam = txtNamaTeamML.getText();
        String namaLeader = txtNamaLeaderML.getText();
        String no_wa = txtNoWAML.getText();
        String player1 =txtNamaPlayerML1.getText();
        String nickname1 = txtNickML1.getText();
        String id1 = txtIDML1.getText();
        String player2 =txtNamaPlayerML2.getText();
        String nickname2 = txtNickML2.getText();
        String id2 = txtIDML2.getText();
        String player3 =txtNamaPlayerML3.getText();
        String nickname3 = txtNickML3.getText();
        String id3 = txtIDML3.getText();
        String player4 =txtNamaPlayerML4.getText();
        String nickname4 = txtNickML4.getText();
        String id4 = txtIDML4.getText();
        String player5 =txtNamaPlayerML5.getText();
        String nickname5 = txtNickML5.getText();
        String id5 = txtIDML5.getText();
        
    }

    private void kosongkanData() {
        txtNoInduk.setEditable(true);
        txtNoInduk.setText(null);
        txtNamaTeamML.setText(null);
        txtNamaLeaderML.setText(null);
        txtNoWAML.setText(null);
        txtNamaPlayerML1.setText(null);
        txtNickML1.setText(null);
        txtIDML1.setText(null);
        txtNamaPlayerML2.setText(null);
        txtNickML2.setText(null);
        txtIDML2.setText(null);
        txtNamaPlayerML3.setText(null);
        txtNickML3.setText(null);
        txtIDML3.setText(null);
        txtNamaPlayerML4.setText(null);
        txtNickML4.setText(null);
        txtIDML4.setText(null);
        txtNamaPlayerML5.setText(null);
        txtNickML5.setText(null);
        txtIDML5.setText(null);
    }
    
    private void printPDF() {
        try {
            String nama = "D:\\Hasil Cetak\\Data Lomba ML IT CONTEST.pdf"; 
        
            //Document document = new Document();
            Document document = new Document(PageSize.A4.rotate(), 10f, 10f, 100f, 0f); 
            
            koneksi koneksiDB = new koneksi();
            Connection conn = koneksiDB.getkoneksi();
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            PdfWriter.getInstance(document, new FileOutputStream(nama));
            document.open();
            
            String query = "SELECT * FROM ml_itcontest";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            Paragraph paragraph1 = new Paragraph("Data Pendaftar Lomba Mobile Legends IT CONTEST");
            Paragraph paragraph2 = new Paragraph("==========================================================");
            Paragraph paragraph3 = new Paragraph("                                                            ");
            
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            
            // Membuat Tabel
            PdfPTable tablePDF = new PdfPTable(19);
            
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
            
            tableCell = new PdfPCell(new Phrase("Nama Player 5"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("Nickname 5"));
            tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tablePDF.addCell(tableCell);
            
            tableCell = new PdfPCell(new Phrase("ID P5"));
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
            
            String Player5 = rs.getString("Player5");
            tableCell = new PdfPCell(new Phrase(Player5));
            tablePDF.addCell(tableCell);

            String Nickname5 = rs.getString("Nickname5");
            tableCell = new PdfPCell(new Phrase(Nickname5));
            tablePDF.addCell(tableCell);
            
            String Id5 = rs.getString("Id5");
            tableCell = new PdfPCell(new Phrase(Id5));
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

        PendaftaranMl = new javax.swing.JPanel();
        MobileLegends = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtNamaPlayerML2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNickML2 = new javax.swing.JTextField();
        txtIDML2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNamaPlayerML3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNickML3 = new javax.swing.JTextField();
        txtIDML3 = new javax.swing.JTextField();
        txtNamaTeamML = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNamaLeaderML = new javax.swing.JTextField();
        txtNamaPlayerML4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNoWAML = new javax.swing.JTextField();
        txtNickML4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNamaPlayerML1 = new javax.swing.JTextField();
        txtIDML4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNickML1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIDML1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNamaPlayerML5 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNickML5 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtIDML5 = new javax.swing.JTextField();
        txtNoInduk = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableML = new javax.swing.JTable();
        btnSubmitML = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PendaftaranMl.setBackground(new java.awt.Color(202, 233, 255));
        PendaftaranMl.setPreferredSize(new java.awt.Dimension(820, 820));
        PendaftaranMl.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 25));

        MobileLegends.setFont(new java.awt.Font("Poppins ExtraBold", 0, 24)); // NOI18N
        MobileLegends.setForeground(new java.awt.Color(27, 73, 101));
        MobileLegends.setText("MOBILE LEGENDS IT CONTEST");
        PendaftaranMl.add(MobileLegends);

        jPanel2.setBackground(new java.awt.Color(202, 233, 255));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(202, 233, 255));

        txtNamaPlayerML2.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayerML2.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayerML2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerML2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(27, 73, 101));
        jLabel9.setText("NickName");

        txtNickML2.setBackground(new java.awt.Color(95, 168, 211));
        txtNickML2.setForeground(new java.awt.Color(255, 255, 255));
        txtNickML2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickML2ActionPerformed(evt);
            }
        });

        txtIDML2.setBackground(new java.awt.Color(95, 168, 211));
        txtIDML2.setForeground(new java.awt.Color(255, 255, 255));
        txtIDML2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDML2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 73, 101));
        jLabel10.setText("Id Player(Server)");

        jLabel11.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 73, 101));
        jLabel11.setText("Player 3");

        txtNamaPlayerML3.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayerML3.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayerML3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerML3ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 73, 101));
        jLabel12.setText("NickName");

        txtNickML3.setBackground(new java.awt.Color(95, 168, 211));
        txtNickML3.setForeground(new java.awt.Color(255, 255, 255));
        txtNickML3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickML3ActionPerformed(evt);
            }
        });

        txtIDML3.setBackground(new java.awt.Color(95, 168, 211));
        txtIDML3.setForeground(new java.awt.Color(255, 255, 255));
        txtIDML3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDML3ActionPerformed(evt);
            }
        });

        txtNamaTeamML.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaTeamML.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaTeamML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaTeamMLActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 73, 101));
        jLabel13.setText("Id Player(Server)");

        jLabel3.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 73, 101));
        jLabel3.setText("Leader");

        jLabel14.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(27, 73, 101));
        jLabel14.setText("Player 4");

        txtNamaLeaderML.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaLeaderML.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaLeaderML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaLeaderMLActionPerformed(evt);
            }
        });

        txtNamaPlayerML4.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayerML4.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayerML4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerML4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 73, 101));
        jLabel4.setText("Nomor WhatsApp");

        jLabel15.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(27, 73, 101));
        jLabel15.setText("NickName");

        txtNoWAML.setBackground(new java.awt.Color(95, 168, 211));
        txtNoWAML.setForeground(new java.awt.Color(255, 255, 255));
        txtNoWAML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoWAMLActionPerformed(evt);
            }
        });

        txtNickML4.setBackground(new java.awt.Color(95, 168, 211));
        txtNickML4.setForeground(new java.awt.Color(255, 255, 255));
        txtNickML4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickML4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 73, 101));
        jLabel5.setText("Player 1");

        jLabel16.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(27, 73, 101));
        jLabel16.setText("Id Player(Server)");

        txtNamaPlayerML1.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayerML1.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayerML1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerML1ActionPerformed(evt);
            }
        });

        txtIDML4.setBackground(new java.awt.Color(95, 168, 211));
        txtIDML4.setForeground(new java.awt.Color(255, 255, 255));
        txtIDML4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDML4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 73, 101));
        jLabel6.setText("NickName");

        txtNickML1.setBackground(new java.awt.Color(95, 168, 211));
        txtNickML1.setForeground(new java.awt.Color(255, 255, 255));
        txtNickML1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickML1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 73, 101));
        jLabel7.setText("Id Player(Server)");

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 73, 101));
        jLabel2.setText("Nama Team");

        txtIDML1.setBackground(new java.awt.Color(95, 168, 211));
        txtIDML1.setForeground(new java.awt.Color(255, 255, 255));
        txtIDML1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDML1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 73, 101));
        jLabel8.setText("Player 2");

        txtNamaPlayerML5.setBackground(new java.awt.Color(95, 168, 211));
        txtNamaPlayerML5.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaPlayerML5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPlayerML5ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 73, 101));
        jLabel17.setText("Player 5");

        jLabel18.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(27, 73, 101));
        jLabel18.setText("NickName");

        txtNickML5.setBackground(new java.awt.Color(95, 168, 211));
        txtNickML5.setForeground(new java.awt.Color(255, 255, 255));
        txtNickML5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickML5ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(27, 73, 101));
        jLabel19.setText("Id Player(Server)");

        txtIDML5.setBackground(new java.awt.Color(95, 168, 211));
        txtIDML5.setForeground(new java.awt.Color(255, 255, 255));
        txtIDML5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDML5ActionPerformed(evt);
            }
        });

        txtNoInduk.setBackground(new java.awt.Color(95, 168, 211));
        txtNoInduk.setForeground(new java.awt.Color(255, 255, 255));
        txtNoInduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoIndukActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(27, 73, 101));
        jLabel20.setText("Nomor Induk");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDML5, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNickML5, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPlayerML5, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDML4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNickML4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPlayerML4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDML3, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNickML3, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPlayerML3, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDML2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNickML2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPlayerML2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDML1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNickML1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPlayerML1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(txtNamaTeamML)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaLeaderML)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoWAML, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txtNoInduk))
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaTeamML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaLeaderML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoWAML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayerML1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickML1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDML1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayerML2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickML2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDML2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayerML3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickML3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDML3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayerML4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickML4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDML4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPlayerML5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickML5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDML5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        tableML.setBackground(new java.awt.Color(95, 168, 211));
        tableML.setForeground(new java.awt.Color(255, 255, 255));
        tableML.setModel(new javax.swing.table.DefaultTableModel(
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
        tableML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableML);

        btnSubmitML.setBackground(new java.awt.Color(98, 182, 203));
        btnSubmitML.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        btnSubmitML.setForeground(new java.awt.Color(27, 73, 101));
        btnSubmitML.setText("Submit");
        btnSubmitML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitMLActionPerformed(evt);
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

        btnDelete.setBackground(new java.awt.Color(95, 168, 211));
        btnDelete.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(27, 73, 101));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmitML, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitML)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnPrint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        PendaftaranMl.add(jPanel2);

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PendaftaranMl, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PendaftaranMl, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaPlayerML2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerML2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerML2ActionPerformed

    private void txtNickML2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickML2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickML2ActionPerformed

    private void txtIDML2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDML2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDML2ActionPerformed

    private void txtNamaPlayerML3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerML3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerML3ActionPerformed

    private void txtNickML3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickML3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickML3ActionPerformed

    private void txtIDML3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDML3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDML3ActionPerformed

    private void txtNamaTeamMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaTeamMLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaTeamMLActionPerformed

    private void txtNamaLeaderMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaLeaderMLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaLeaderMLActionPerformed

    private void txtNamaPlayerML4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerML4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerML4ActionPerformed

    private void txtNoWAMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoWAMLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoWAMLActionPerformed

    private void txtNickML4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickML4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickML4ActionPerformed

    private void txtNamaPlayerML1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerML1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerML1ActionPerformed

    private void txtIDML4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDML4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDML4ActionPerformed

    private void txtNickML1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickML1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickML1ActionPerformed

    private void txtIDML1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDML1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDML1ActionPerformed

    private void txtNamaPlayerML5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPlayerML5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPlayerML5ActionPerformed

    private void txtNickML5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickML5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickML5ActionPerformed

    private void txtIDML5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDML5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDML5ActionPerformed

    private void btnSubmitMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitMLActionPerformed
        // TODO add your handling code here:
        conn = (Connection) koneksi.getkoneksi();

        try {

            String sql = "INSERT INTO ml_itcontest VALUES('" + txtNoInduk.getText() + "','"  + txtNamaTeamML.getText() + "','" + txtNamaLeaderML.getText() + "','" + txtNoWAML.getText() + "','" + txtNamaPlayerML1.getText() + "','" + txtNickML1.getText() + "','" + txtIDML1.getText() + "','" + txtNamaPlayerML2.getText() + "','" + txtNickML2.getText() + "','" + txtIDML2.getText()
                    + "','" + txtNamaPlayerML3.getText() + "','" + txtNickML3.getText() + "','" + txtIDML3.getText() + "','" + txtNamaPlayerML4.getText() + "','" + txtNickML4.getText() + "','" + txtIDML4.getText() + "','" + txtNamaPlayerML5.getText() + "','" + txtNickML5.getText() + "','" + txtIDML5.getText() + "')";
            // String sql = "INSERT INTO pubgm VALUES('"+ txtNamaTeamML.getText() + "','" + txtNamaLeaderML.getText() + "','" + txtNoWAML.getText() + "','" + txtNamaPlayerML1.getText() + "','" + txtNickML1.getText() + "','" + txtIDML1.getText() + "')";

            java.sql.Connection conn = (java.sql.Connection) koneksi.getkoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Data Tersimpan");

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilData();
        kosongkanData();
    }//GEN-LAST:event_btnSubmitMLActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ML ml = new ML();
        ml.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMLMouseClicked
        // TODO add your handling code here:
        int baris = tableML.rowAtPoint(evt.getPoint());

        String Nomor_induk = tableML.getValueAt(baris, 1).toString();
        txtNoInduk.setText(Nomor_induk);

        String nama_Team = tableML.getValueAt(baris, 2).toString();
        txtNamaTeamML.setText(nama_Team);

        String Leader = tableML.getValueAt(baris, 3).toString();
        txtNamaLeaderML.setText(Leader);

        String no_wa = tableML.getValueAt(baris, 4).toString();
        txtNoWAML.setText(no_wa);

        String Player1 = tableML.getValueAt(baris, 5).toString();
        txtNamaPlayerML1.setText(Player1);

        String nick1 = tableML.getValueAt(baris, 6).toString();
        txtNickML1.setText(nick1);

        String id1 = tableML.getValueAt(baris, 7).toString();
        txtIDML1.setText(id1);

        String Player2 = tableML.getValueAt(baris, 8).toString();
        txtNamaPlayerML2.setText(Player2);

        String nick2 = tableML.getValueAt(baris, 9).toString();
        txtNickML2.setText(nick2);

        String id2 = tableML.getValueAt(baris, 10).toString();
        txtIDML2.setText(id2);

        String Player3 = tableML.getValueAt(baris, 11).toString();
        txtNamaPlayerML3.setText(Player3);

        String nick3 = tableML.getValueAt(baris, 12).toString();
        txtNickML3.setText(nick3);

        String id3 = tableML.getValueAt(baris, 13).toString();
        txtIDML3.setText(id3);

        String Player4 = tableML.getValueAt(baris, 14).toString();
        txtNamaPlayerML4.setText(Player4);

        String nick4 = tableML.getValueAt(baris, 15).toString();
        txtNickML4.setText(nick4);

        String id4 = tableML.getValueAt(baris, 16).toString();
        txtIDML4.setText(id4);

        String Player5 = tableML.getValueAt(baris, 17).toString();
        txtNamaPlayerML5.setText(Player5);

        String nick5 = tableML.getValueAt(baris, 18).toString();
        txtNickML5.setText(nick5);

        String id5 = tableML.getValueAt(baris, 19).toString();
        txtIDML5.setText(id5);
    }//GEN-LAST:event_tableMLMouseClicked

    private void txtNoIndukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoIndukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoIndukActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        try {
            
            String sql = "UPDATE ml_itcontest set Nomor_induk = '"+ txtNoInduk.getText() +"', Nama_Team = '"+ txtNamaTeamML.getText() + "', Nama_Leader = '" + txtNamaLeaderML.getText() + "', No_Wa = '" + txtNoWAML.getText() 
                    + "', Player1 = '"+ txtNamaPlayerML1.getText() + "', Nickname1 = '" + txtNickML1.getText() + "', Id1 = '" + txtIDML1.getText()
                    + "', Player2 = '"+ txtNamaPlayerML2.getText() + "', Nickname2 = '" + txtNickML2.getText() + "', Id2 = '" + txtIDML2.getText()
                    + "', Player3 = '"+ txtNamaPlayerML3.getText() + "', Nickname3 = '" + txtNickML3.getText() + "', Id3 = '" + txtIDML3.getText()
                    + "', Player4 = '"+ txtNamaPlayerML4.getText() + "', Nickname4 = '" + txtNickML4.getText() + "', Id4 = '" + txtIDML4.getText()
                    + "', Player5 = '"+ txtNamaPlayerML5.getText() + "', Nickname5 = '" + txtNickML5.getText() + "', Id5 = '" + txtIDML5.getText() 
                    + "' WHERE Nomor_induk = '" + txtNoInduk.getText() + "'";
            // String sql = "INSERT INTO pubgm VALUES('"+ txtNamaTeamML.getText() + "','" + txtNamaLeaderML.getText() + "','" + txtNoWAML.getText() + "','" + txtNamaPlayerML1.getText() + "','" + txtNickML1.getText() + "','" + txtIDML1.getText() + "')";
             
            java.sql.Connection conn = (java.sql.Connection) koneksi.getkoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();

            
            //bersihText();
            JOptionPane.showMessageDialog(null, "Update Data Berhasil");

            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilData();
        kosongkanData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
        String sql = "DELETE FROM ml_itcontest WHERE Nomor_induk='"+txtNoInduk.getText()+"'";
            
             
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

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        printPDF();
    }//GEN-LAST:event_btnPrintActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_ml_itcontest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MobileLegends;
    private javax.swing.JPanel PendaftaranMl;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSubmitML;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableML;
    private javax.swing.JTextField txtIDML1;
    private javax.swing.JTextField txtIDML2;
    private javax.swing.JTextField txtIDML3;
    private javax.swing.JTextField txtIDML4;
    private javax.swing.JTextField txtIDML5;
    private javax.swing.JTextField txtNamaLeaderML;
    private javax.swing.JTextField txtNamaPlayerML1;
    private javax.swing.JTextField txtNamaPlayerML2;
    private javax.swing.JTextField txtNamaPlayerML3;
    private javax.swing.JTextField txtNamaPlayerML4;
    private javax.swing.JTextField txtNamaPlayerML5;
    private javax.swing.JTextField txtNamaTeamML;
    private javax.swing.JTextField txtNickML1;
    private javax.swing.JTextField txtNickML2;
    private javax.swing.JTextField txtNickML3;
    private javax.swing.JTextField txtNickML4;
    private javax.swing.JTextField txtNickML5;
    private javax.swing.JTextField txtNoInduk;
    private javax.swing.JTextField txtNoWAML;
    // End of variables declaration//GEN-END:variables
}
