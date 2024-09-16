package com.project.autos.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO de la consulta una compra
 */
public class CompraResponseDto {

    private Integer numberBill;

    private Integer cardIdDate;

    private LocalDateTime date;

    private Double total;

    private String paymentMethod;

    private List<AutoCompraResponseDto> carsPurchase;
}
