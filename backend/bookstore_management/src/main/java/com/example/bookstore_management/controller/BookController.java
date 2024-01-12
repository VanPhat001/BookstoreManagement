package com.example.bookstore_management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore_management.model.Book;
import com.example.bookstore_management.repository.BookRepository;
import com.example.bookstore_management.service.BookService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getMethodName() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getMethodName(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            Book book = bookService.findById(id);
            return ResponseEntity.ok(book); 
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/find/regex/{text}")
    public ResponseEntity<?> getMethodName(@PathVariable String text) {
        try {
            return ResponseEntity.ok(bookService.findByRegex(text));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body(null);
    }
    
}
