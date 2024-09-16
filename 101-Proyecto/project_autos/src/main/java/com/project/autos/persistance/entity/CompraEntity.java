package com.project.autos.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad de compra
 */
@Getter
@Setter
@Entity
@Table(name = "compras")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer numberBill;

    @Column(name = "clientedni")
    private Integer cardIdDate;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @Column(name = "total")
    private Double total;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @ManyToOne()
    @JoinColumn(name = "clientedni", insertable = false, updatable = false)
    private ClienteEntity clienteEntity;

    @OneToMany(mappedBy = "compraEntity", cascade = {CascadeType.ALL})
    private List<AutoCompraEntity> carsPurchase;
}
