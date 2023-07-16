package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.persistance.entity.CarEntity;
import com.project.coches.persistance.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*
* Mapper de compras
* */
@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseRequestDto toPurchaseDto(PurchaseEntity purchaseEntity);

    @Mapping(target = "customerEntity",ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseRequestDto> toPurchaseRequestDtoList(List<PurchaseEntity> purchaseEntityList);
}
