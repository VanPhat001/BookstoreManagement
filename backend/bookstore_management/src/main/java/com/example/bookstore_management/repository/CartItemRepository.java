package com.example.bookstore_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bookstore_management.compositeKey.CartItemKey;
import com.example.bookstore_management.model.CartItem;

import jakarta.transaction.Transactional;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {

    List<CartItem> findByCustomerId(Integer id);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM cart_item c WHERE c.customer_id = :customerId AND c.book_id = :bookId")
    void deleteByCustomerIdAndBookId(@Param("customerId") Integer customerId, @Param("bookId") Integer bookId);

    CartItem findByBookIdAndCustomerId(Integer bookId, Integer customerId);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE cart_item SET quantity=:quantity WHERE customer_id=:customerId and book_id=:bookId")
    void updateCartItemQuantity(@Param("bookId") Integer bookId, @Param("customerId") Integer customerId,
            @Param("quantity") Integer quantity);
}
