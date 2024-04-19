package com.example.demo;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Persona {
    @Id
    private Long id;
    @ManyToMany(mappedBy = "personas")
    private Set<Direccion> direcciones;
}
