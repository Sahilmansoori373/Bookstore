package com.example.BookStore.entity;


import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class CartItem {

        @Id

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "cart_id")
        private ShoppingCart shoppingCart;

        @ManyToOne
        @JoinColumn(name = "book_id")
        private Book book;

        private int quantity;


        public CartItem(Book book, ShoppingCart shoppingCart, int quantity) {
        this.book = book;
        this.shoppingCart = shoppingCart;
        this.quantity = quantity;
        }
}
