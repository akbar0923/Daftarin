package TUGAS_BESAR;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class koneksi {
    private static Connection koneksi;
    
    public static Connection getkoneksi(){
        if(koneksi == null){
            try{
                String url = new String ();
                String user = new String ();
                String password = new String ();
                url = "jdbc:mysql://localhost:3306/daftarin";
                user = "root";
                password="";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi =(Connection) DriverManager.getConnection(url,user,password);
                System.out.println("Berhasil");
            }catch(SQLException t){
                System.out.println("Login Gagal" + t.getMessage());
                
            }
        }
        return koneksi;
    }
    
    public static void main(String[] args) {
        getkoneksi();
    }
}
