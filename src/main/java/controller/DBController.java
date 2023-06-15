package controller;

import domain.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carli
 */
public class DBController {
    public static int dropId;
    public static String selectName;
    public static Book book;
    public static Connection connection = null;
    public static PreparedStatement pstm = null;
    public static Statement stm = null;
    public static ResultSet rst = null;
    public static String dropBook= "DELETE FROM biblioteca WHERE idBook = "+dropId+";"; 
    public static String SELECT_NAME_BOOK = "SELECT idBook, name, author, editorial, stock, price FROM book "
            + "WHERE CONTAINS(name, '"+selectName+"';";
    public static String ALL_LIST_BOOK = "SELECT idBook, name, author, editorial, stock, price FROM book;";
    public static String CREATE_DB_BIBLIOTECA = "CREATE DATABASE IF NOT EXISTS biblioteca;";
    public static String DROP_DB_BIBLIOTECA = "DROP DATABASE IF EXISTS biblioteca;";
    public static String USE_DB_BIBLIOTECA = "USE biblioteca;";
    public static String CREATE_TB_BOOK = "CREATE TABLE IF NOT EXISTS book"
            + "(idBook int primary key , name varchar(100) not null, author varchar(100) not null,"
            + "editorial varchar(100) not null, stock int not null, price float(6, 2) not null);";

    public static void createDBBiblioteca() {
        try {
            connection = DBConnection.connectRootDB();
            pstm = connection.prepareStatement(CREATE_DB_BIBLIOTECA);
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                DBConnection.closePStm(pstm);
                DBConnection.closeConnectDB(connection);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }

    public static void useDBBiblioteca() {
        try {
            connection = DBConnection.connectRootDB();
            pstm = connection.prepareStatement(USE_DB_BIBLIOTECA);
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                DBConnection.closePStm(pstm);
                DBConnection.closeConnectDB(connection);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }

    public static void dropDBBiblioteca() {
        try {
            connection = DBConnection.connectRootDB();
            pstm = connection.prepareStatement(DROP_DB_BIBLIOTECA);
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                DBConnection.closePStm(pstm);
                DBConnection.closeConnectDB(connection);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }

    public static void createTbBook() {
        try {
            connection = DBConnection.connectRootDB();
            pstm = connection.prepareStatement(CREATE_TB_BOOK);
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                DBConnection.closePStm(pstm);
                DBConnection.closeConnectDB(connection);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }

    public static List<Book> listBook() {
        List<Book> list = new ArrayList<>();

        try {
            connection = DBConnection.connectRootDB();
            pstm = connection.prepareStatement(ALL_LIST_BOOK);
            rst = pstm.executeQuery();
            while (rst.next()) {
                int idBook = rst.getInt("idBook");
                String name = rst.getString("name");
                String author = rst.getString("author");
                String editorial = rst.getString("editorial");
                int stock = rst.getInt("stock");
                float price = rst.getFloat("price");

                book = new Book(idBook, name, author, editorial, stock, price);
                list.add(book);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                DBConnection.closeConnectDB(rst);
                DBConnection.closePStm(pstm);
                DBConnection.closeConnectDB(connection);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        return list;
    }

    public static List<Book> selectNameBook(String selectName) {
        DBController.selectName=selectName;
        List<Book> list = new ArrayList<>();
        try {
            connection = DBConnection.connectRootDB();
            pstm = connection.prepareStatement(SELECT_NAME_BOOK);
            rst = pstm.executeQuery();
            while (rst.next()) {
                int idBook = rst.getInt("idBook");
                String name = rst.getString("name");
                String author = rst.getString("author");
                String editorial = rst.getString("editorial");
                int stock = rst.getInt("stock");
                float price = rst.getFloat("price");

                book = new Book(idBook, name, author, editorial, stock, price);
                list.add(book);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                DBConnection.closeConnectDB(rst);
                DBConnection.closePStm(pstm);
                DBConnection.closeConnectDB(connection);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        return list;
    }
    public static void dropBook(int idBook) {
        DBController.dropId=idBook;
        try {
            connection = DBConnection.connectRootDB();
            pstm = connection.prepareStatement(SELECT_NAME_BOOK);
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                DBConnection.closePStm(pstm);
                DBConnection.closeConnectDB(connection);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }
}
