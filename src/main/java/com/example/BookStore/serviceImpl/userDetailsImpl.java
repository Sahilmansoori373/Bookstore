package com.example.BookStore.serviceImpl;

import com.example.BookStore.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class userDetailsImpl implements UserDetails {

    private User user;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Collection<? extends GrantedAuthority> authorities;

    public userDetailsImpl(User user) {
        this.user = user;
    }

    // Constructor to build from a User entity
    public userDetailsImpl(String username, String email, String password, boolean isAccountNonExpired,
                           boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled,
                           Collection<? extends GrantedAuthority> authorities) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
    }

    // Getters and Setters for your fields
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void setUserfirstname(String firstname) {this.firstname = firstname;}
    public void setUserlastname(String lastname) {this.lastname = lastname;}
    public void setPassword(String password) { this.password = password; }
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) { this.authorities = authorities; }
    public void setAccountNonExpired(boolean isAccountNonExpired) { this.isAccountNonExpired = isAccountNonExpired; }
    public void setAccountNonLocked(boolean isAccountNonLocked) { this.isAccountNonLocked = isAccountNonLocked; }
    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) { this.isCredentialsNonExpired = isCredentialsNonExpired; }
    public void setEnabled(boolean isEnabled) { this.isEnabled = isEnabled; }

    // Implementation of UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() {
        return firstname;
    }

    public String getUserfirstname() { return firstname; }
    public String getUserlastname() { return lastname; }

    @Override
    public boolean isAccountNonExpired() { return isAccountNonExpired; }

    @Override
    public boolean isAccountNonLocked() { return isAccountNonLocked; }

    @Override
    public boolean isCredentialsNonExpired() { return isCredentialsNonExpired; }

    @Override
    public boolean isEnabled() { return isEnabled; }
}