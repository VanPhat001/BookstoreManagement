package com.example.bookstore_management.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bookstore_management.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query (nativeQuery = true, value = "select * from book where book.name like :queryString")
    List<Book> findByRegexName(@Param(value = "queryString") String queryString);
    
}
