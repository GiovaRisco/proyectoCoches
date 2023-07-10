package com.project.coches.controller;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    /*
    * Devuelve lista de marcasCoche
    * */
    @GetMapping
    public ResponseEntity<List<BrandCarDto>>  getAll(){
        return ResponseEntity.ok(iBrandCarService.getAll());
        //return ResponseEntity.status(HttpStatus.OK)
        //      .body(iBrandCarService.getAll()); -- Alternativa
        //return new ResponseEntity<>(iBrandCarService.getAll(),HttpStatus.OK); Alternatica para crear Response_Entity
    }

    /*
    * Devuelve una marcaCoche dada su Id
    * HttpCode Ok , si la encuentra , HttpCode Not-Found si no es el caso
    * */
    @GetMapping("/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable("id") Integer id){
        return  ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    /*
    * Crea una nueva marcaCoche
    * */
    @PostMapping
    public  ResponseEntity<BrandCarDto> save(@RequestBody BrandCarDto newBrandCar){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(newBrandCar));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }


    /*
    * Actualiza una marcaCoche
    * */
    @PatchMapping
    public ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto brandCarDtoUpdate){

        return  ResponseEntity.of( iBrandCarService.update(brandCarDtoUpdate));
    }


    /*
    * Elimina una marcaCoche dada su Id
    * */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id")Integer id){
        return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
