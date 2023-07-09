package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/*
* Entidad de marca_coche
* */
@Entity
@Table(name = "marca_coche")
@Getter
@Setter
public class BrandCarEntity {

    /*
     * Id de la marca
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Descripcion de la marca
     */
    @Column(name = "descripcion")
    private String description;
}
