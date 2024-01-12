package com.example.bookstore_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bookstore_management.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUsernameAndPassword(String username, String password); 
}
