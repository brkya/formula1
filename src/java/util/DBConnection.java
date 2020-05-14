package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Burak
 */
public class DBConnection {

    private static DBConnection instance;
    private static Connection connection;

    private DBConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/formula1", "postgres", "123");
            System.out.println("Database Connection successful");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public static DBConnection getInstance() {
        try {
            if (instance == null) {
                instance = new DBConnection();
            } else if (instance.getConnection().isClosed()) {
                instance = new DBConnection();
            }
            return instance;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }
    
    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DBConnection.connection = connection;
    }

}
