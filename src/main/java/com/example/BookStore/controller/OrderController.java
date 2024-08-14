package com.example.BookStore.controller;

import com.example.BookStore.entity.Order;
import com.example.BookStore.entity.User;
import com.example.BookStore.service.UserService;
import com.example.BookStore.serviceImpl.OrderServiceImpl;
import com.example.BookStore.serviceImpl.ShoppingCartImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartImpl shoppingCartService;

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.userDetailsService(email);

        Order order = orderService.createOrderFromCart(user);
        return ResponseEntity.ok(order);
    }

}
