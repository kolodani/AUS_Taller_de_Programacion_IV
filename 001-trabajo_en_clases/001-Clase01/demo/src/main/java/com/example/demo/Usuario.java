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
}
