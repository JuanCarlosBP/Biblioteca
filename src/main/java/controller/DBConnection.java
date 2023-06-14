package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author carli
 */
public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PSSWD = "";

    public static Connection connectRootDB() throws SQLException {
        return DriverManager.getConnection(URL, USER, PSSWD);
    }

    public static Connection connectDB(String user, String psswd) throws SQLException {
        return DriverManager.getConnection(URL, user, psswd);
    }

    public static void closeConnectDB(Connection connection) throws SQLException {
        connection.close();
    }

    public static void closeStm(Statement stm) throws SQLException {
        stm.close();
    }

    public static void closePStm(PreparedStatement pstm) throws SQLException {
        pstm.close();
    }

    public static void closeConnectDB(ResultSet rst) throws SQLException {
        rst.close();
    }
}
