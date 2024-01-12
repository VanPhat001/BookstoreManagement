package com.example.bookstore_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore_management.model.Customer;
import com.example.bookstore_management.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomer(String username, String password) {
        return customerRepository.findByUsernameAndPassword(username, password);
    }
}
