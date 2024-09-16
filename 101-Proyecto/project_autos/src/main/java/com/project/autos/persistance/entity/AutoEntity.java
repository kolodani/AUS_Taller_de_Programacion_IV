package com.project.autos.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entidad Auto
 */
@Getter
@Setter
@Entity
@Table(name = "autos")
public class AutoEntity {

    @Id
    @Column(name = "codigo_auto")
    private String codeCar;

    @Column(name = "marca_id")
    private Integer brandCarId;

    @Column(name = "referencias")
    private String reference;

    @Column(name = "precio")
    private Double price;

    @Column(name = "modelo")
    private Double modelYear;

    @Column(name = "color")
    private String color;

    @Column(name = "caballos_fuerza")
    private String horsepower;

    @Column(name = "cantidad_puestas")
    private Integer numberDoor;

    @Column(name = "cilindraje")
    private Double engineDisplacement;

    @Column(name = "automatico")
    private String transmission;

    @Column(name = "es_diesel")
    private String fuelType;

    @Column(name = "cantidad_asientos")
    private Integer numberSeat;

    @Column(name = "traccion")
    private Integer traction;

    @Column(name = "direccion")
    private String steering;

    @Column(name = "categoria")
    private String category;

    @Column(name = "pwd_auto")
    private String pathImage;

    @ManyToOne
    @JoinColumn(name = "marca_id", insertable = false, updatable = false)
    private MarcaAutoEntity brandCarEntity;

    @OneToMany(mappedBy = "autoEntity")
    private List<AutoCompraEntity> autoCompraEntity;
}
