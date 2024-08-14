package com.example.BookStore.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.Set;
@Data
@Entity
@Table(name = "`order`")
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        private Date orderDate;
        private String status;

        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
        private Set<OrderItem> orderItems;

}
