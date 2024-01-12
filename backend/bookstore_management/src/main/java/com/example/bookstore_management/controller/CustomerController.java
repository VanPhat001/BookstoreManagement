package com.example.bookstore_management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore_management.model.Customer;
import com.example.bookstore_management.service.CustomerService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getMethodName() {
        try {
            return ResponseEntity.ok(customerService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getMethodName(@PathVariable Integer id) {
        try {
            var data = customerService.findById(id);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Customer> postMethodName(@RequestBody Customer customer) {
        if (customer != null) {
            Customer data = customerService.create(customer);
            return ResponseEntity.ok(data);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/find")
    public ResponseEntity<Customer> findCustomer(@RequestBody Map<String, String> body) {

        String username = body.get("username");
        String password = body.get("password");

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            Customer customer = customerService.findCustomer(username, password);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body(null);
    }

}
