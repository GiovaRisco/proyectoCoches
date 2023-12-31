package com.project.coches.domain.service;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.domain.useCase.IBrandCarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* Servicio de marca coche
* */
@RequiredArgsConstructor
@Service
public class BrandCarService implements IBrandCarUseCase {

    /*
    * Repository de marca coce
    * */
    private final IBrandCarRepository iBrandCarRepository;

    /*
     * Devuelve una lista con todas las marcas de coches
     * */
    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarRepository.getAll();
    }


    /**
     *Devuelve una marca de coche dada su id
     */

    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    /*
     * Guarda una nueva marca de coche
     * */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }


    /*
     * Actualiza marca coche
     * */
    @Override
    public Optional<BrandCarDto> update(BrandCarDto updateBrandCar) {
        if (iBrandCarRepository.getBrandCar(updateBrandCar.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iBrandCarRepository.save(updateBrandCar));
    }

    /*
     * Elimina una marca coche dada su Id
     * */
    @Override
    public boolean delete(Integer idBrandCar) {
        if (iBrandCarRepository.getBrandCar(idBrandCar).isEmpty()){
            return false;
        }
        iBrandCarRepository.delete(idBrandCar);
            return true;
    }
}
