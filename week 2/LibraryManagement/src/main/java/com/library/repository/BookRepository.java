package com.library.repository;

/**
 * Simulates a data access layer for Book entities.
 * In a real application, this would talk to a database via JDBC/JPA.
 */
public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository: instance created.");
    }

    public String findBookById(int id) {
        // Simulated lookup - normally this would query a database
        return "Book{id=" + id + ", title='Effective Java', author='Joshua Bloch'}";
    }

    public void saveBook(String title) {
        System.out.println("BookRepository: saving book '" + title + "' to the data store.");
    }
}
