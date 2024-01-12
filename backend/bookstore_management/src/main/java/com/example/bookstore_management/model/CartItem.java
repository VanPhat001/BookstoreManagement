package com.example.bookstore_management.model;

import com.example.bookstore_management.compositeKey.CartItemKey;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@IdClass(CartItemKey.class)
public class CartItem {
    @Id
    private Integer customerId;
    @Id
    private Integer bookId;
    private Integer quantity;
}
