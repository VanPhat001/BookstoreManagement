package com.example.bookstore_management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore_management.model.CartItem;
import com.example.bookstore_management.repository.CartItemRepository;
import com.example.bookstore_management.service.CartItemService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/cart-item")
@CrossOrigin(origins = "*")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @DeleteMapping("/{customerId}/{bookId}")
    public ResponseEntity<Boolean> deleteCartItem(@PathVariable Integer customerId, @PathVariable Integer bookId) {
        try {
            cartItemService.deleteCartItemByCustomerIdAndBookId(customerId, bookId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ResponseEntity.badRequest().body(false);
    }
}
