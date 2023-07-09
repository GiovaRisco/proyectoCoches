package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.MarcaCochePojo;
import com.project.coches.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*
*@Mapper que transforma objetos de MarcaCoche a POJOS o Entidades
* */
@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    /*
    * Recibo un entity y lo transformamos a un POJO
    * */
    /*Con esta anotacion nos dirá
    * Recibes (source) MarcaCocheEntity y lo conviertes a (target)MarcaCochePojo
    */
    /*
    * @param marcaEntity Entidad a convertir
    * @return Pojo convertido
     */

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaCochePojo toMarcaCochePojo(MarcaCocheEntity marcaEntity);

    /*Este @InheritInverseConfiguration es para hacer la inversa del Mapping*/
    /*
     * @param marcaPojo Pojo a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaPojo);

    /*
    * Retorna una lista de marcasCoche transformada a Pojo de una lista de entidades
    * */

    List<MarcaCochePojo> toMarcaCochePojo(List<MarcaCocheEntity> marcasCocheEntity);
}
