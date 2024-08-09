package com.example.BookStore.serviceImpl;

import com.example.BookStore.entity.User;
import com.example.BookStore.repository.UserRepo;
import com.example.BookStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepo userRepo;

    @Override
    public User userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return (UserDetails) userRepo.findByEmail(username)
                        .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
            }
        };
    }
}
