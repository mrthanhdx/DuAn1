package DBcontext;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext1 {

    public static String USER = "sa";
    public static String PASSWORD = "12345678";
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=DuAN1;encrypt=true;trustServerCertificate=true";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

//    public static void main(String[] args) {
//        Connection con = getConnection();
//        if (con != null) {
//            System.out.println("Kết nối thành công");
//        } else {
//            System.out.println("Lỗi kết nối");
//        }
    
}
