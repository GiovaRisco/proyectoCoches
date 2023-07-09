package com.project.coches.domain.service;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.repository.IBrandCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* Servicio de marca coche
* */
@RequiredArgsConstructor
@Service
public class BrandCarService implements IBrandCarService{

    /*
    * Repository de marca coce
    * */
    private final IBrandCarRepository iBrandCarRepository;

    /*
     * Devuelve una lista con todas las marcas de coches
     * */
    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarRepository.getAll();
    }


    /**
     *Devuelve una marca de coche dada su id
     */

    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    /*
     * Guarda una nueva marca de coche
     * */
    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    /*
     * Elimina una marca coche dada su Id
     * */
    @Override
    public boolean delete(Integer idBrandCar) {
        try {
            iBrandCarRepository.delete(idBrandCar);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
}