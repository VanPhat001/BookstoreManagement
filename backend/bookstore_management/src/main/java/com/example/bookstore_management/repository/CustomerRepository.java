package com.example.bookstore_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bookstore_management.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUsernameAndPassword(String username, String password);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE customer SET username=:username, password=:password, email=:email, avatar=:avatar, name=:name, gender=:gender, phone=:phone, address=:address WHERE id = :id")
    void updateCustomer(@Param("id") Integer id, @Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("avatar") String avatar, @Param("name") String name, @Param("gender") String gender, @Param("phone") String phone, @Param("address") String address); 
}
