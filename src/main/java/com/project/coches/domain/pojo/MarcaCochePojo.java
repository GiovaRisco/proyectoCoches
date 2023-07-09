package com.project.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

//No usar @Data : es una mala practica

/*
* Pojo de marca coche Entity
* */
@Getter
@Setter
public class MarcaCochePojo {

    /*
    * Id de la marca
     */
    private Integer id;

    /**
     * Descripcion de la marca
     */
    private String description;
}
