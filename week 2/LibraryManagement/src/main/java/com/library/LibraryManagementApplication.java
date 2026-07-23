package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("=== Loading Spring Application Context ===");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== Context loaded. Retrieving beans ===");

        BookService bookService = context.getBean("bookService", BookService.class);

        System.out.println("=== Testing Dependency Injection ===");
        bookService.getBookDetails(101);
        bookService.addBook("Clean Code");
    }
}
