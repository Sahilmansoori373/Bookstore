package com.example.BookStore.service;

import com.example.BookStore.dto.JwtAuthenticationResponse;
import com.example.BookStore.dto.RefreshTokenRequest;
import com.example.BookStore.dto.SignInRequest;
import com.example.BookStore.dto.SignUpRequest;
import com.example.BookStore.entity.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
//    User signin(SignInRequest signinRequest);


    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
