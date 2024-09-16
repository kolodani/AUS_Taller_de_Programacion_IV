package com.project.autos.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entidad de un cliente
 */
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @Column(name = "dni")
    private Integer dni;

    @Column(name = "nombre_cliente")
    private String fullName;

    @Column(name = "email_cliente")
    private String email;

    @Column(name = "celular_cliente")
    private Double numberCellphone;

    @Column(name = "activo")
    private Integer active;

    @Column(name = "contrasenia")
    private String password;

    @OneToMany(mappedBy = "clienteEntity")
    private List<CompraEntity> compraEntity;
}
