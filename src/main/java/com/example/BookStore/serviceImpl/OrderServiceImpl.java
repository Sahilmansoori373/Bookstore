package com.example.BookStore.serviceImpl;

import com.example.BookStore.entity.*;
import com.example.BookStore.repository.OrderItemRepository;
import com.example.BookStore.repository.OrderRepository;
import com.example.BookStore.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ShoppingCartImpl shoppingCartService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public Order createOrderFromCart(User user) {
        ShoppingCart shoppingCart = shoppingCartService.getCartByUser(user);
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setStatus("PENDING");

        orderRepository.save(order);

        for (CartItem cartItem : shoppingCart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setBook(cartItem.getBook());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getBook().getPrice());

            orderItemRepository.save(orderItem);
            order.getOrderItems().add(orderItem);
        }

        shoppingCart.getCartItems().clear();
        shoppingCartRepository.save(shoppingCart);

        return order;
    }

}
