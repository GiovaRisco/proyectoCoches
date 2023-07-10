package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

//No usar @Data : es una mala practica

/*
* Pojo de marca coche Entity
* */
@Getter
@Setter
public class BrandCarDto {

    /*
    * Id de la marca
     */
    private Integer id;

    /**
     * Descripcion de la marca
     */
    private String description;
}
