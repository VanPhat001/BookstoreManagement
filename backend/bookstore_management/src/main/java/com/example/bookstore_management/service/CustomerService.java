package com.example.bookstore_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore_management.model.Customer;
import com.example.bookstore_management.repository.CustomerRepository;

import jakarta.transaction.Transactional;

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

    @Transactional
    public Boolean updateCustomer(Customer customer) {
        Customer _customer = customerRepository.findById(customer.getId()).orElse(null);

        if (_customer == null) {
            return false;
        }

        if (!_customer.getPassword().equals(customer.getPassword())) {
            return false;
        }

        customerRepository.updateCustomer(
                customer.getId(),
                customer.getUsername(),
                customer.getPassword(),
                customer.getEmail(),
                customer.getAvatar(),
                customer.getName(),
                customer.getGender(),
                customer.getPhone(),
                customer.getAddress());

        return true;
    }
}
