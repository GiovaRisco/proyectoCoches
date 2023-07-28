package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarPurchaseRequestDto;
import com.project.coches.persistance.entity.CarPurchaseEntity;
import com.project.coches.persistance.entity.CarPurchasePK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-25T23:41:54-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class ICarPurchaseMapperImpl implements ICarPurchaseMapper {

    @Override
    public CarPurchaseEntity toCarPurchaseEntity(CarPurchaseRequestDto carPurchaseRequestDto) {
        if ( carPurchaseRequestDto == null ) {
            return null;
        }

        CarPurchaseEntity carPurchaseEntity = new CarPurchaseEntity();

        carPurchaseEntity.setId( carPurchaseRequestDtoToCarPurchasePK( carPurchaseRequestDto ) );
        carPurchaseEntity.setCuantityCars( carPurchaseRequestDto.getCuantityCars() );
        carPurchaseEntity.setTotalPriceCars( carPurchaseRequestDto.getTotalPriceCars() );

        return carPurchaseEntity;
    }

    protected CarPurchasePK carPurchaseRequestDtoToCarPurchasePK(CarPurchaseRequestDto carPurchaseRequestDto) {
        if ( carPurchaseRequestDto == null ) {
            return null;
        }

        CarPurchasePK carPurchasePK = new CarPurchasePK();

        carPurchasePK.setCodeCar( carPurchaseRequestDto.getCodeCar() );

        return carPurchasePK;
    }
}
