package com.project.autos.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "autos_compras")
public class AutoCompraEntity {

    @EmbeddedId
    private AutoCompraPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "total")
    private Integer total;

    @ManyToOne()
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)
    private CompraEntity compraEntity;

    @ManyToOne
    @JoinColumn(name = "autos_codigo_auto", insertable = false, updatable = false)
    private AutoEntity autoEntity;
}
