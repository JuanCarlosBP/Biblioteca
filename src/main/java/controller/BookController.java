/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.DBController;
import domain.Book;
import java.util.List;

/**
 *
 * @author carli
 */
public class BookController {

    Book libro;

    public static void resetBookManagement() {
        DBController.dropDBBiblioteca();
        DBController.createDBBiblioteca();
        DBController.createTbBook();
    }

    public static void createBookManagement() {
        DBController.createDBBiblioteca();
        DBController.createTbBook();
    }

    public static List<Book> allBookList() {
        return DBController.listBook();
    }

    public static List<Book> allBookList(String name) {
        return DBController.selectNameBook(name);
    }
}
