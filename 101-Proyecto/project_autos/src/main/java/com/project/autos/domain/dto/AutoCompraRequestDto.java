package com.project.autos.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto del guardado de los autos de una compra
 */
@Getter
@Setter
public class AutoCompraRequestDto {

    private Integer purchaseNumberBill;

    private String codeCar;

    private Integer quantity;

    private Integer total;
}
