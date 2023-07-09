package com.project.coches.domain.repository;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

    /*
    * Devuelve una lista con todas las marcas de coches
    * */
    List<BrandCarPojo> getAll();

    /**
     *Devuelve una marca de coche dada su id
     */

    //Optional : Nos puede venir un objeto o nada
    Optional<BrandCarPojo> getBrandCar(Integer id);


    /*
    * Guarda una nueva marca de coche
    * */
    BrandCarPojo save(BrandCarPojo newBrandCar);


    /*
    * Elimina una marca coche dada su Id
    * */
    void delete(Integer idBrandCar);

}
