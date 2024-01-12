package com.example.bookstore_management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore_management.model.Book;
import com.example.bookstore_management.model.CartItem;
import com.example.bookstore_management.repository.BookRepository;
import com.example.bookstore_management.repository.CartItemRepository;

@Service
public class ShoppingCartService {
    @Autowired 
    CartItemRepository cartItemRepository;

    @Autowired 
    BookRepository bookRepository;
    
    public Map<String, List<Object>> getShoppingCartByCustomerId(Integer customerId) {
        Map<String, List<Object>> result = new HashMap<String, List<Object>>();

        List<CartItem> cartItemList = cartItemRepository.findByCustomerId(customerId);
        List<Book> bookList = new ArrayList<Book>();
        
        for (CartItem cartItem : cartItemList) {
            Integer bookId = cartItem.getBookId();
            Optional<Book> book = bookRepository.findById(bookId);
            
            if (book != null) {
                bookList.add(book.get());
            }
        }
        
        result.put("cartItems",  new ArrayList<Object>(cartItemList));
        result.put("books", new ArrayList<Object>(bookList));

        return result;
    }
}
