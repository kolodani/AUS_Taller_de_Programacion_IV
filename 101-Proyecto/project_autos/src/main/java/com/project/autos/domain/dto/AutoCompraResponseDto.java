package com.project.autos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO de la consulta de los autos de una compra
 */
@Getter
@Setter
@AllArgsConstructor
public class AutoCompraResponseDto {

    private String referenceCar;

    private Integer quantity;

    private Integer total;
}
