package com.example.BookStore.repository;

import com.example.BookStore.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository  extends JpaRepository<CartItem , Long> {
}
