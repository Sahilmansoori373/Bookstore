package com.example.BookStore.serviceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;@Service
public class userDetailsImpl implements UserDetails {

    private String username;
    private String email;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Collection<? extends GrantedAuthority> authorities;

    // Default constructor
    public userDetailsImpl() {}

    public String getEmail() {
        return email;
    }

    // Setter methods
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setAccountNonExpired(boolean isAccountNonExpired) { this.isAccountNonExpired = isAccountNonExpired; }
    public void setAccountNonLocked(boolean isAccountNonLocked) { this.isAccountNonLocked = isAccountNonLocked; }
    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) { this.isCredentialsNonExpired = isCredentialsNonExpired; }
    public void setEnabled(boolean isEnabled) { this.isEnabled = isEnabled; }
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) { this.authorities = authorities; }

    // Implement methods from UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }
    @Override
    public String getPassword() { return password; }
    @Override
    public String getUsername() { return username; }
    @Override
    public boolean isAccountNonExpired() { return isAccountNonExpired; }
    @Override
    public boolean isAccountNonLocked() { return isAccountNonLocked; }
    @Override
    public boolean isCredentialsNonExpired() { return isCredentialsNonExpired; }
    @Override
    public boolean isEnabled() { return isEnabled; }
}
