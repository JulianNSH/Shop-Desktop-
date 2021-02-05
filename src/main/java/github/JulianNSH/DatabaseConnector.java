package github.JulianNSH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Class for connecting to database
 */
public class DatabaseConnector {
    private static final String url = "jdbc:postgresql://localhost:5432/shop";
    public static String user;
    public static String password;

    public DatabaseConnector(){}

    public static Connection connect(String user, String password) {
        DatabaseConnector.user = user;
        DatabaseConnector.password = password;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            //System.out.println("Connected to PG server");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}