package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.persistance.entity.BrandCarEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-10T00:35:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IBrandCarMapperImpl implements IBrandCarMapper {

    @Override
    public BrandCarPojo toBrandCarPojo(BrandCarEntity marcaEntity) {
        if ( marcaEntity == null ) {
            return null;
        }

        BrandCarPojo brandCarPojo = new BrandCarPojo();

        brandCarPojo.setId( marcaEntity.getId() );
        brandCarPojo.setDescription( marcaEntity.getDescription() );

        return brandCarPojo;
    }

    @Override
    public BrandCarEntity toBrandCarEntity(BrandCarPojo marcaPojo) {
        if ( marcaPojo == null ) {
            return null;
        }

        BrandCarEntity brandCarEntity = new BrandCarEntity();

        brandCarEntity.setId( marcaPojo.getId() );
        brandCarEntity.setDescription( marcaPojo.getDescription() );

        return brandCarEntity;
    }

    @Override
    public List<BrandCarPojo> toBrandCarListPojo(List<BrandCarEntity> marcasCocheEntity) {
        if ( marcasCocheEntity == null ) {
            return null;
        }

        List<BrandCarPojo> list = new ArrayList<BrandCarPojo>( marcasCocheEntity.size() );
        for ( BrandCarEntity brandCarEntity : marcasCocheEntity ) {
            list.add( toBrandCarPojo( brandCarEntity ) );
        }

        return list;
    }
}
