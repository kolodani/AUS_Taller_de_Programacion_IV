package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String genero;
    private String telefono;
    // va a cambiar cuando cree la entidad Direccion
    private String direccion;

    // constructor vacio por defecto
    public Persona() {
    }

    // constructor con parametros
    public Persona(String nombre, String apellido, String genero, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}
