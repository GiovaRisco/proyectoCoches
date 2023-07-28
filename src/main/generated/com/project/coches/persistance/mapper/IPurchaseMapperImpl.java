package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarPurchaseRequestDto;
import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.persistance.entity.CarPurchaseEntity;
import com.project.coches.persistance.entity.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-25T23:41:54-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IPurchaseMapperImpl implements IPurchaseMapper {

    @Autowired
    private ICarPurchaseMapper iCarPurchaseMapper;

    @Override
    public PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto) {
        if ( purchaseRequestDto == null ) {
            return null;
        }

        PurchaseEntity purchaseEntity = new PurchaseEntity();

        purchaseEntity.setNumberBill( purchaseRequestDto.getNumberBill() );
        purchaseEntity.setCardIdCustomer( purchaseRequestDto.getCardIdCustomer() );
        purchaseEntity.setDate( purchaseRequestDto.getDate() );
        purchaseEntity.setTotal( purchaseRequestDto.getTotal() );
        purchaseEntity.setPaymentMethod( purchaseRequestDto.getPaymentMethod() );
        purchaseEntity.setCarsPurchase( carPurchaseRequestDtoListToCarPurchaseEntityList( purchaseRequestDto.getCarsPurchase() ) );

        return purchaseEntity;
    }

    protected List<CarPurchaseEntity> carPurchaseRequestDtoListToCarPurchaseEntityList(List<CarPurchaseRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CarPurchaseEntity> list1 = new ArrayList<CarPurchaseEntity>( list.size() );
        for ( CarPurchaseRequestDto carPurchaseRequestDto : list ) {
            list1.add( iCarPurchaseMapper.toCarPurchaseEntity( carPurchaseRequestDto ) );
        }

        return list1;
    }
}
