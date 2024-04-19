package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Id;
import java.util.Set;

@Entity
public class Direccion {
    @Id
    private Long id;
    @ManyToMany(mappedBy = "direcciones")
    private Set<Persona> personas;
}
