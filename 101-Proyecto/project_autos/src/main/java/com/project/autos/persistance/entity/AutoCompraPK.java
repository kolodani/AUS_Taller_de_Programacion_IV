package com.project.autos.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class AutoCompraPK implements Serializable {

    @Serial
    private static final long serialVersionUID = -2145479604343286721L;

    @Column(name = "compras_numero_factura")
    private Integer purchaseNumberBill;

    @Column(name = "autos_codigo_auto")
    private String codeCar;
}
