/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author H
 */
public class ConnectionProvider {
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=DuAntest;encrypt=true;trustServerCertificate=true";
    static String username = "sa";
    static String password = "12345678";
    
    public static Connection getConnection(){
        Connection connection = null;
        try {
           connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
     public static void main(String[] args) {
         Connection con = getConnection();   
        if (con!=null) {
            System.out.println("ket noi thanh cong");
        } else {
            System.out.println("ket noi that bai");
        }
    }
}
