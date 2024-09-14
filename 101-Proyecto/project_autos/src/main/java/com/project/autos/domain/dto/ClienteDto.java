package com.project.autos.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto de un cliente
 */
@Getter
@Setter
public class ClienteDto {

    private Integer dni;

    private String fullName;

    private String email;

    private Double numberCellphone;

    private Integer active;

    private String password;
}
