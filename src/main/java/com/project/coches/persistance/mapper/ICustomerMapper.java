package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.persistance.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*
* Mapear el cliente
* */
@Mapper(componentModel = "spring" )
public interface ICustomerMapper {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    @Mapping(target = "purchaseEntity", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomerDtoList (List<CustomerEntity> customerEntityList);
}
