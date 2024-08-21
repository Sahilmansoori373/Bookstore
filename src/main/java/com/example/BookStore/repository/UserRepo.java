package com.example.BookStore.repository;

import com.example.BookStore.entity.Role;
import com.example.BookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUserfirstname(String firstname);
    Optional<User> findByEmail(String email);
    User findByRole(Role role);

}
