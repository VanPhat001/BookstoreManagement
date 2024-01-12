package com.example.bookstore_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore_management.model.Book;
import com.example.bookstore_management.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findByRegex(String text) {
        String[] words = text.trim().split(" ");
        String queryString = "%";

        for (String word : words) {
            queryString += word + "%";
        }

        return bookRepository.findByRegexName(queryString);
    }
}
