package com.example.BookStore.serviceImpl;

import com.example.BookStore.entity.User;
import com.example.BookStore.repository.UserRepo;
import com.example.BookStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private  final UserRepo userRepo;

    @Override
    public User userDetailsService(String email) {
        return userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("User Not Found"));
    }
}
