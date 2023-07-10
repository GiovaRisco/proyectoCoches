package com.project.coches.domain.service;

import com.project.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

    /*
     * Devuelve una lista con todas las marcas de coches
     * */
    List<BrandCarDto> getAll();

    /**
     *Devuelve una marca de coche dada su id
     */

    //Optional : Nos puede venir un objeto o nada
    Optional<BrandCarDto> getBrandCar(Integer id);


    /*
     * Guarda una nueva marca de coche
     * */
    BrandCarDto save(BrandCarDto newBrandCar);

    /*
    * Actualiza marca coche
    * */
    Optional<BrandCarDto> update(BrandCarDto updateBrandCar);


    /*
     * Elimina una marca coche dada su Id
     * */
    boolean delete(Integer idBrandCar);
}
