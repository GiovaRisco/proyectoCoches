package com.project.coches.controller;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/*
* Controlador Rest de marca coche
* */
@RequiredArgsConstructor
@RestController
@RequestMapping("/marcas-coches")
public class BrandCarController {

    /*
    * Servicio de marca coche
    * */
    private final IBrandCarService iBrandCarService;

    @GetMapping
    public ResponseEntity<List<BrandCarPojo>>  getAll(){
        return ResponseEntity.ok(iBrandCarService.getAll());
        //return ResponseEntity.status(HttpStatus.OK)
        //      .body(iBrandCarService.getAll()); -- Alternativa
        //return new ResponseEntity<>(iBrandCarService.getAll(),HttpStatus.OK); Alternatica para crear Response_Entity
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable("id") Integer id){
        return  ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    @PostMapping
    public  ResponseEntity<BrandCarPojo> save(@RequestBody BrandCarPojo newBrandCar){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(newBrandCar));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }


}
