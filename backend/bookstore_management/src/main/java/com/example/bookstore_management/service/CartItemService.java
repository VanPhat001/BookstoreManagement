package com.example.bookstore_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore_management.model.CartItem;
import com.example.bookstore_management.repository.CartItemRepository;

import jakarta.transaction.Transactional;

@Service
public class CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;


    @Transactional
    public void deleteCartItemByCustomerIdAndBookId(Integer customerId, Integer bookId) {
        cartItemRepository.deleteByCustomerIdAndBookId(customerId, bookId);
    }

    @Transactional
    public void increaseCartItemQuantiy(Integer bookId, Integer customerId, Integer value) {
        CartItem cartItem = cartItemRepository.findByBookIdAndCustomerId(bookId, customerId);

        if (cartItem == null) {
            cartItemRepository.save(new CartItem(customerId, bookId, value));
            return;
        }

        Integer newQuantity = cartItem.getQuantity() + value;
        if (newQuantity <= 0) {
            cartItemRepository.deleteByCustomerIdAndBookId(customerId, bookId);
        } else {
            cartItemRepository.updateCartItemQuantity(bookId, customerId, newQuantity);
        }
    }
}
