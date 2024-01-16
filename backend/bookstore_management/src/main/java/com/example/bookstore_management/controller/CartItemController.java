package com.example.bookstore_management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore_management.model.CartItem;
import com.example.bookstore_management.repository.CartItemRepository;
import com.example.bookstore_management.service.CartItemService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PatchMapping("/increase")
    public ResponseEntity<Boolean> increaseQuantity(@RequestBody Map<String, Integer> body) {
        try {
            Integer bookId = body.get("bookId");
            Integer customerId = body.get("customerId");
            Integer value = body.get("value"); // value can be recived positive or negative number
            
            if (bookId == null || customerId == null || value == null) {
                return ResponseEntity.badRequest().body(false);
            }

            cartItemService.increaseCartItemQuantiy(bookId, customerId, value);

            return ResponseEntity.ok( true );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body(false);
    }
}
