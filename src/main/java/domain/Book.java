/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author carli
 */
public class Book {
    private String name;
    private String author;
    private String editorial;
    private int stock;
    private float price;
    private int idBook;
    private static int id;

    public Book() {
        this.idBook=++id;
    }

    public Book(String name, String author, String editorial, int stock, float price) {
        this.name = name;
        this.author = author;
        this.editorial = editorial;
        this.stock = stock;
        this.price = price;
        this.idBook=++id;
    }

    public Book(int idBook, String name, String author, String editorial, int stock, float price) {
        this.name = name;
        this.author = author;
        this.editorial = editorial;
        this.stock = stock;
        this.price = price;
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }
    
    
}
