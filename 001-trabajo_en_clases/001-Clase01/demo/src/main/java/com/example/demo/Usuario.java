package com.example.demo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Usuario {
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Usuario(){};

    public Usuario(boolean enabled, String username, String password, String email){
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
