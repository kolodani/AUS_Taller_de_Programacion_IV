package com.project.autos.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca auto
 */
@Getter
@Setter
public class MarcaAutoDto {

    /**
     * Id de la marca
     */
    private Integer id;

    /**
     * Descripcion de la marca
     */
    private String description;

}
