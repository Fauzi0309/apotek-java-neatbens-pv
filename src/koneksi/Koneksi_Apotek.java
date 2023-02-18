/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package koneksi;
import java.sql.*;

/**
 *
 * @author mendieto
 */
public class Koneksi_Apotek {
    private Connection koneksi;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("sudah tersambung");
        }
        catch(ClassNotFoundException ex){
            System.out.println("gagal tersambung"+ex);
        }
        String url = "jdbc:mysql://localhost/apotek";
        try{
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("berhasil tersambung ke database");
        }
        catch (SQLException ex){
            System.out.println("gagal koneksi database"+ex);
        }
        return koneksi;
    }
}