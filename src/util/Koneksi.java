package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection conn;
    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // untuk MySQL Connector 8+
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_gudang",
                    "root", ""); // ubah password jika perlu
            } catch (ClassNotFoundException e) {
                System.out.println("Driver tidak ditemukan: " + e.getMessage());
            }
        }
        return conn;
    }
}
