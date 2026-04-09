package com.example.monumentbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role")
    private String role;
    
    @Column(name = "auth_token")
    private String authToken;

    // ✅ GETTERS

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return passwordHash;
    }

    public String getRole() {
        return role;
    }

    public String getAuthToken() {
        return authToken;
    }

    // ✅ SETTERS

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}