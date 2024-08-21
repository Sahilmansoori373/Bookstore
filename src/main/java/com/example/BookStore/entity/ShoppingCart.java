package com.example.BookStore.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class ShoppingCart {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "user_id")
        private User user;

        @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
        private Set<CartItem> cartItems;


        public ShoppingCart(User user) {
                this.user = user;
        }
}
