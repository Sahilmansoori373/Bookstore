package com.example.BookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String author;
        private BigDecimal price;
        private String description;

        @OneToMany(mappedBy = "book")
        private Set<OrderItem> orderItems;

        @OneToMany(mappedBy = "book")
        private Set<CartItem> cartItems;

}
