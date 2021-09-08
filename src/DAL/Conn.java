package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conn {
    private static Connection con;

    public static boolean openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost/java";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        Conn.con = con;
    }
}
