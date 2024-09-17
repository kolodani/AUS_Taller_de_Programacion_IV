package com.project.autos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto de un cliente
 */
@Getter
@Setter
@AllArgsConstructor
public class ClienteDto {

    private Integer dni;

    private String fullName;

    private String email;

    private Double numberCellphone;

    private Integer active;

    private String password;

    private String rol;
}
