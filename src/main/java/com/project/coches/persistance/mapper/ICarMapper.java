package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.persistance.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {

    @Mapping(source = "brandCarEntity.description", target = "brandCarString")
    @Mapping(source = "stock", target = "stock")
    CarDto toCarDto(CarEntity carEntity);

    @Mapping(target = "brandCarEntity",ignore = true)
    @Mapping(target = "carPurchaseEntity",ignore = true)
    @Mapping(source = "stock", target = "stock")
    CarEntity toCarEntity(CarDto carDto);

    List<CarDto> toCarDtoList(List<CarEntity> carEntityList);
}
