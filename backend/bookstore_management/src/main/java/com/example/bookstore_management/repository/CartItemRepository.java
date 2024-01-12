package com.example.bookstore_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore_management.compositeKey.CartItemKey;
import com.example.bookstore_management.model.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {

    List<CartItem> findByCustomerId(Integer id);
}
