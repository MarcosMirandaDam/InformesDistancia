package org.swing.informesdistancia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sssoc
 */
public class ConnectionManager {

    private static final String HOST = "localhost";
    private static final String DB = "sakila";
    private static final String user = "root";
    private static final String password = "root";
    private static final String PORT = "3306";

    public static Connection getMySqlConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB;

            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException | ClassNotFoundException ex) {                           // las dos excepciones
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
