package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.persistance.entity.CustomerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-25T23:41:54-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class ICustomerMapperImpl implements ICustomerMapper {

    @Override
    public CustomerDto toCustomerDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCardId( customerEntity.getCardId() );
        customerDto.setFullName( customerEntity.getFullName() );
        customerDto.setEmail( customerEntity.getEmail() );
        customerDto.setNumberCellphone( customerEntity.getNumberCellphone() );
        customerDto.setActive( customerEntity.getActive() );
        customerDto.setPassword( customerEntity.getPassword() );
        customerDto.setRol( customerEntity.getRol() );

        return customerDto;
    }

    @Override
    public CustomerEntity toCustomerEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCardId( customerDto.getCardId() );
        customerEntity.setFullName( customerDto.getFullName() );
        customerEntity.setEmail( customerDto.getEmail() );
        customerEntity.setNumberCellphone( customerDto.getNumberCellphone() );
        customerEntity.setActive( customerDto.getActive() );
        customerEntity.setPassword( customerDto.getPassword() );
        customerEntity.setRol( customerDto.getRol() );

        return customerEntity;
    }

    @Override
    public List<CustomerDto> toCustomerDtoList(List<CustomerEntity> customerEntityList) {
        if ( customerEntityList == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( customerEntityList.size() );
        for ( CustomerEntity customerEntity : customerEntityList ) {
            list.add( toCustomerDto( customerEntity ) );
        }

        return list;
    }
}
