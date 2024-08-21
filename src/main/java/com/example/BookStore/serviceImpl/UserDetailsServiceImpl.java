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

import java.nio.file.attribute.UserPrincipal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private  final UserRepo userRepo;

    public User loadByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }


    @Override
    public UserDetails loadUserByUsername(String firstname) throws UsernameNotFoundException {
        User user = userRepo.findByUserfirstname(firstname);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }

        return new userDetailsImpl(user);
    }


}
