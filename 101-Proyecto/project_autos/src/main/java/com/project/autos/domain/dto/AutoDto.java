package com.project.autos.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto de auto
 */
@Getter
@Setter
public class AutoDto {

    private String codeCar;

    private Integer brandCarId;

    private String reference;

    private Double price;

    private Double modelYear;

    private String color;

    private String horsepower;

    private Integer numberDoor;

    private Double engineDisplacement;

    private String transmission;

    private String fuelType;

    private Integer numberSeat;

    private Integer traction;

    private String steering;

    private String category;

    private String pathImage;
}
