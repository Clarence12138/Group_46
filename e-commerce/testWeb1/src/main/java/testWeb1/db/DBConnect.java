package testWeb1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBURL = "jdbc:mysql://127.0.0.1:3306/javawebdb";
    private final String DBUSER = "root";
    private final String DBPASSWORD = "111111";
    private static Connection conn = null;

    /**
     * Constructor to establish a database connection
     */
    public DBConnect() {
        try {
            // Load the database driver
            Class.forName(DBDRIVER);
            // Establish the database connection
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Get the database connection object
     * @return The database connection object
     */
    public static Connection getConnection() {
        return conn;
    }

    /**
     * Close the database connection
     */
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            // Ignore exceptions when closing the connection
        }
    }

}