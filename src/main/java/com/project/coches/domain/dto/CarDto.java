package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/*
* Dto que modele carro
* */
 @Getter @Setter
public class CarDto {

    private Integer codeCar;

    private Integer brandCar;

    private String reference;

    private Double price;

    private Double modelYear;

    private String color;

    private Double horsePower;

    private Integer numberDoor;

    private Double engineDisplacement;

    private String transmission;

    private String fuelType;

    private Integer numberSeats;

    private Integer traction;

    private String steering;

    private String category;

    private String imagePath;


}
