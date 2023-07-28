package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.persistance.crud.ICarCrudRepository;
import com.project.coches.persistance.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepository  implements  ICarRepository{

    private final ICarCrudRepository iCarCrudRepository;

    private final ICarMapper iCarMapper;
    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarDtoList(iCarCrudRepository.findAll());
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {
        return iCarMapper.toCarDtoList(iCarCrudRepository.findAllByBrandCar(idBrandCar));
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return iCarMapper.toCarDtoList(iCarCrudRepository.findAllByPriceLessThanOrderByPriceDesc(price));
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return iCarCrudRepository.findById(idCar)
                .map(iCarMapper::toCarDto);
    }

    @Override
    public CarDto save(CarDto newCar) {
        return iCarMapper
                .toCarDto(iCarCrudRepository
                        .save(iCarMapper
                                .toCarEntity(newCar)));
    }

    @Override
    public void delete(Integer idCar) {
        iCarCrudRepository.deleteById(idCar);
    }
}
