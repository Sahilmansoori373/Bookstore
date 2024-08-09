package com.example.BookStore.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class OrderItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order;

        @ManyToOne
        @JoinColumn(name = "book_id")
        private Book book;

        private int quantity;
        private BigDecimal price;


}
