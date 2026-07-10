package com.library.service;

import com.library.repository.BookRepository;

/**
 * Service layer that depends on BookRepository.
 * The dependency is injected by Spring via the setter method below
 * (Exercise 2: setter-based Dependency Injection).
 */
public class BookService {

    private BookRepository bookRepository;

    public BookService() {
        System.out.println("BookService: instance created.");
    }

    // Setter used by Spring for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookService: BookRepository injected via setter.");
        this.bookRepository = bookRepository;
    }

    public void getBookDetails(int id) {
        if (bookRepository == null) {
            System.out.println("BookService: BookRepository is not set!");
            return;
        }
        String book = bookRepository.findBookById(id);
        System.out.println("BookService: retrieved -> " + book);
    }

    public void addBook(String title) {
        if (bookRepository == null) {
            System.out.println("BookService: BookRepository is not set!");
            return;
        }
        bookRepository.saveBook(title);
    }
}
