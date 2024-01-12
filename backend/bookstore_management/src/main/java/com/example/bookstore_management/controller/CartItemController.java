package com.example.bookstore_management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore_management.repository.CartItemRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/cart-item")
@CrossOrigin(origins = "*")
public class CartItemController {
    @Autowired
    CartItemRepository cartItemRepository;

    // @GetMapping("/customer/{customerId}")
    // public List<ShoppingCartDTO> getMethodName(@PathVariable Integer customerId) {
    //     return cartItemRepository.getShoppingCart(customerId);
    //     // return shoppingCartRepository.getShoppingCart(customerId);
    // }
}
