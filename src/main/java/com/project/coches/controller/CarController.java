package com.project.coches.controller;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.useCase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final ICarUseCase iCarUseCase;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll(){
        return ResponseEntity.ok(iCarUseCase.getAll());
    }

    @GetMapping("/brand-car/{idBrandCar}")
    public ResponseEntity<List<CarDto>> getCarByBrandCar(@PathVariable("idBrandCar") Integer idBrandCar){
        return ResponseEntity.ok(iCarUseCase.getCarByIdBrandCar(idBrandCar));
    }

    @GetMapping("/price/{priceCar}")
    public ResponseEntity<List<CarDto>> getCarByPriceLessThan(@PathVariable("priceCar") Double priceCar){
        return ResponseEntity.ok(iCarUseCase.getCarsByPriceLessThan(priceCar));
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarDto> getCar(@PathVariable("carId") Integer carId){
        return  ResponseEntity.of(iCarUseCase.getCar(carId));
    }

    @PostMapping
    public  ResponseEntity<CarDto> save(@RequestBody CarDto newCar){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCarUseCase.save(newCar));

    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Boolean> delete(@PathVariable("carId")Integer carId){
        return new ResponseEntity<>(this.iCarUseCase.delete(carId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
