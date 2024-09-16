package com.project.autos.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad de marca coche
 */
@Getter
@Setter
@Entity
@Table(name = "marca_auto")
public class MarcaAutoEntity {

    /**
     * Id de la marca
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Descripcion de la marca
     */
    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "brandCarEntity", orphanRemoval = true)
    private List<AutoEntity> carEntities;
}


