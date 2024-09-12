package com.project.autos.persistance.mapper;

import com.project.autos.domain.pojo.MarcaAutoPojo;
import com.project.autos.persistance.entity.MarcaAutoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T16:30:56-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class IMarcaAutoMapperImpl implements IMarcaAutoMapper {

    @Override
    public MarcaAutoPojo toMarcaAutoPojo(MarcaAutoEntity marcaEntity) {
        if ( marcaEntity == null ) {
            return null;
        }

        MarcaAutoPojo marcaAutoPojo = new MarcaAutoPojo();

        marcaAutoPojo.setId( marcaEntity.getId() );
        marcaAutoPojo.setDescription( marcaEntity.getDescription() );

        return marcaAutoPojo;
    }

    @Override
    public MarcaAutoEntity toMarcaAutoEntity(MarcaAutoPojo marcaPojo) {
        if ( marcaPojo == null ) {
            return null;
        }

        MarcaAutoEntity marcaAutoEntity = new MarcaAutoEntity();

        marcaAutoEntity.setId( marcaPojo.getId() );
        marcaAutoEntity.setDescription( marcaPojo.getDescription() );

        return marcaAutoEntity;
    }

    @Override
    public List<MarcaAutoPojo> toMarcasAutosPojo(List<MarcaAutoEntity> marcasCocheEntity) {
        if ( marcasCocheEntity == null ) {
            return null;
        }

        List<MarcaAutoPojo> list = new ArrayList<MarcaAutoPojo>( marcasCocheEntity.size() );
        for ( MarcaAutoEntity marcaAutoEntity : marcasCocheEntity ) {
            list.add( toMarcaAutoPojo( marcaAutoEntity ) );
        }

        return list;
    }
}
