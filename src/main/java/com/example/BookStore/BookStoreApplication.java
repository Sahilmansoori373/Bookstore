package com.example.BookStore;

import com.example.BookStore.entity.Role;
import com.example.BookStore.entity.User;
import com.example.BookStore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BookStoreApplication {

//	@Autowired
//	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

//	public void run(String... args){
//		User AdminAccount = userRepo.findByRole(Role.ADMIN);
//		if (null==AdminAccount){
//			User user = new User();
//			user.setEmail("admin@gmail.com");
//			user.setFirstname("admin");
//			user.setLastname("admin");
//			user.setRole(Role.ADMIN);
//			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
//			userRepo.save(user);
//		}
//	}

}
