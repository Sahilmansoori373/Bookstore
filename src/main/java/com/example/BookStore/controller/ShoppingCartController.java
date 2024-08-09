package com.example.BookStore.controller;

import com.example.BookStore.entity.Book;
import com.example.BookStore.entity.CartItem;
import com.example.BookStore.entity.ShoppingCart;
import com.example.BookStore.entity.User;
import com.example.BookStore.service.UserService;
import com.example.BookStore.serviceImpl.BookServiceImpl;
import com.example.BookStore.serviceImpl.ShoppingCartImpl;
import com.example.BookStore.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartImpl shoppingCartService;

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<ShoppingCart> addToCart(@RequestParam Long bookId, @RequestParam int quantity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user;
        user = userService.userDetailsService(String email);

        Book book = bookService.findById(bookId);
        ShoppingCart shoppingCart = shoppingCartService.addToCart(user, book, quantity);
        return ResponseEntity.ok(shoppingCart);
    }

    @GetMapping
    public ResponseEntity<ShoppingCart> viewCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.userDetailsService(String email);

        ShoppingCart shoppingCart = shoppingCartService.getCartByUser(user);
        return ResponseEntity.ok(shoppingCart);
    }

}
