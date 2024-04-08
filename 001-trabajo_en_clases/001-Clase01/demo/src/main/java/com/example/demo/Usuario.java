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

    // constructor vacio por defecto
    public Usuario() {
    }

    // constructor con parametros
    public Usuario(String username, String password, String email, boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.id = 100000L;
    }
}
