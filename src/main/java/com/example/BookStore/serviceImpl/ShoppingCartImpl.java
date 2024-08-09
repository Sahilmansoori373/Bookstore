package com.example.BookStore.serviceImpl;

import com.example.BookStore.entity.Book;
import com.example.BookStore.entity.CartItem;
import com.example.BookStore.entity.ShoppingCart;
import com.example.BookStore.entity.User;
import com.example.BookStore.repository.CartItemRepository;
import com.example.BookStore.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartImpl {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public ShoppingCart addToCart(User user, Book book, int quantity) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user)
                .orElse(new ShoppingCart(user));

        Optional<CartItem> cartItemOptional = shoppingCart.getCartItems().stream()
                .filter(item -> item.getBook().getId().equals(book.getId()))
                .findFirst();

        CartItem cartItem;
        if (cartItemOptional.isPresent()) {
            cartItem = cartItemOptional.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = new CartItem(book, shoppingCart, quantity);
            shoppingCart.getCartItems().add(cartItem);
        }

        shoppingCartRepository.save(shoppingCart);
        cartItemRepository.save(cartItem);

        return shoppingCart;
    }

    public ShoppingCart getCartByUser(User user) {
        return shoppingCartRepository.findByUser(user)
                .orElse(new ShoppingCart(user));
    }
}
