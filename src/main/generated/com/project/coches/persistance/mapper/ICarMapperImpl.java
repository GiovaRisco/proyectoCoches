package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.persistance.entity.CarEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-13T22:06:24-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class ICarMapperImpl implements ICarMapper {

    @Override
    public CarDto toCarDto(CarEntity carEntity) {
        if ( carEntity == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setCodeCar( carEntity.getCodeCar() );
        carDto.setBrandCar( carEntity.getBrandCar() );
        carDto.setReference( carEntity.getReference() );
        carDto.setPrice( carEntity.getPrice() );
        carDto.setModelYear( carEntity.getModelYear() );
        carDto.setColor( carEntity.getColor() );
        carDto.setHorsePower( carEntity.getHorsePower() );
        carDto.setNumberDoor( carEntity.getNumberDoor() );
        carDto.setEngineDisplacement( carEntity.getEngineDisplacement() );
        carDto.setTransmission( carEntity.getTransmission() );
        carDto.setFuelType( carEntity.getFuelType() );
        carDto.setNumberSeats( carEntity.getNumberSeats() );
        carDto.setTraction( carEntity.getTraction() );
        carDto.setSteering( carEntity.getSteering() );
        carDto.setCategory( carEntity.getCategory() );
        carDto.setImagePath( carEntity.getImagePath() );

        return carDto;
    }

    @Override
    public CarEntity toCarEntity(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setCodeCar( carDto.getCodeCar() );
        carEntity.setBrandCar( carDto.getBrandCar() );
        carEntity.setReference( carDto.getReference() );
        carEntity.setPrice( carDto.getPrice() );
        carEntity.setModelYear( carDto.getModelYear() );
        carEntity.setColor( carDto.getColor() );
        carEntity.setHorsePower( carDto.getHorsePower() );
        carEntity.setNumberDoor( carDto.getNumberDoor() );
        carEntity.setEngineDisplacement( carDto.getEngineDisplacement() );
        carEntity.setTransmission( carDto.getTransmission() );
        carEntity.setFuelType( carDto.getFuelType() );
        carEntity.setNumberSeats( carDto.getNumberSeats() );
        carEntity.setTraction( carDto.getTraction() );
        carEntity.setSteering( carDto.getSteering() );
        carEntity.setCategory( carDto.getCategory() );
        carEntity.setImagePath( carDto.getImagePath() );

        return carEntity;
    }

    @Override
    public List<CarDto> toCarDtoList(List<CarEntity> carEntityList) {
        if ( carEntityList == null ) {
            return null;
        }

        List<CarDto> list = new ArrayList<CarDto>( carEntityList.size() );
        for ( CarEntity carEntity : carEntityList ) {
            list.add( toCarDto( carEntity ) );
        }

        return list;
    }
}
