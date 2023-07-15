package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*
*@Mapper que transforma objetos de MarcaCoche a POJOS o Entidades
* */
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {

    /*
    * Recibo un entity y lo transformamos a un POJO
    * */
    /*Con esta anotacion nos dirá
    * Recibes (source) BrandCarEntity y lo conviertes a (target)BrandCarPojo
    */
    /*
    * @param marcaEntity Entidad a convertir
    * @return Dto convertido
     */

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarDto toBrandCarDto(BrandCarEntity marcaEntity);

    /*Este @InheritInverseConfiguration es para hacer la inversa del Mapping*/
    /*
     * @param marcaDto Dto a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    @Mapping(target = "carEntities",ignore = true)
    BrandCarEntity toBrandCarEntity(BrandCarDto marcaPojo);

    /*
    * Retorna una lista de marcasCoche transformada a Pojo de una lista de entidades
    * */

    List<BrandCarDto> toBrandCarListDto(List<BrandCarEntity> marcasCocheEntity);
}
