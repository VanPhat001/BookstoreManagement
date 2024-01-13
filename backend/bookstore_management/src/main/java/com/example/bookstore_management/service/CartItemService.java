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
}
