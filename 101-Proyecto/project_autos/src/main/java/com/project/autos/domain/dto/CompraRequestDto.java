package com.project.autos.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto del guardado de una compra
 */
public class CompraRequestDto {

    private Integer numberBill;

    private Integer cardIdDate;

    private LocalDateTime date;

    private Double total;

    private String paymentMethod;

    private List<AutoCompraRequestDto> carsPurchase;
}
