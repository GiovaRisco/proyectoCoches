package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.persistance.crud.IBrandCarCrudRepository;
import com.project.coches.persistance.entity.BrandCarEntity;
import com.project.coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/*Repositorio de marcacoche*/
@RequiredArgsConstructor /*Genera el constructor solo  para los objetos FINAL en este caso : IBrandCarCrudRepository , IBrandCarMapper*/
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    /*
    *Crud de marca coche
    */
    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    /*
     *Mapper de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;


    /*
    * Devuelve un alista con todos las marcas de coche
    * */
    @Override
    public List<BrandCarDto> getAll() {
        //Convertimos la lista de marcaCochesEntity a una lista de marcaCochePojo
        return iBrandCarMapper.toBrandCarListDto(iBrandCarCrudRepository.findAll());
    }

    /*
    *Devuelve una marca de coche dada su Id
    * */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id)
                .map(iBrandCarMapper::toBrandCarDto);
        //brandCarEntity -> iBrandCarMapper.toBrandCarPojo(brandCarEntity) -LAMBDA
        //iBrandCarMapper::toBrandCarPojo Metodo por Referencia
    }

    /*
     * Guarda una nueva marca de coche
     * */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        //Transformamos a un Entity el Pojo recibido
        BrandCarEntity brandCarEntity = iBrandCarMapper.toBrandCarEntity(newBrandCar);
        //Al guardar , convertimos el Entity a un Pojo
        return iBrandCarMapper.toBrandCarDto(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /*
     * Elimina una marca coche dada su Id
     * */
    @Override
    public void delete(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);
    }
}
