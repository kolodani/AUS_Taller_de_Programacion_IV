package com.project.autos.persistance.mapper;

import com.project.autos.domain.dto.MarcaAutoDto;
import com.project.autos.persistance.entity.MarcaAutoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T15:40:54-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class IMarcaAutoMapperImpl implements IMarcaAutoMapper {

    @Override
    public MarcaAutoDto toMarcaAutoPojo(MarcaAutoEntity marcaEntity) {
        if ( marcaEntity == null ) {
            return null;
        }

        MarcaAutoDto marcaAutoDto = new MarcaAutoDto();

        marcaAutoDto.setId( marcaEntity.getId() );
        marcaAutoDto.setDescription( marcaEntity.getDescription() );

        return marcaAutoDto;
    }

    @Override
    public MarcaAutoEntity toMarcaAutoEntity(MarcaAutoDto marcaPojo) {
        if ( marcaPojo == null ) {
            return null;
        }

        MarcaAutoEntity marcaAutoEntity = new MarcaAutoEntity();

        marcaAutoEntity.setId( marcaPojo.getId() );
        marcaAutoEntity.setDescription( marcaPojo.getDescription() );

        return marcaAutoEntity;
    }

    @Override
    public List<MarcaAutoDto> toMarcasAutosPojo(List<MarcaAutoEntity> marcasCocheEntity) {
        if ( marcasCocheEntity == null ) {
            return null;
        }

        List<MarcaAutoDto> list = new ArrayList<MarcaAutoDto>( marcasCocheEntity.size() );
        for ( MarcaAutoEntity marcaAutoEntity : marcasCocheEntity ) {
            list.add( toMarcaAutoPojo( marcaAutoEntity ) );
        }

        return list;
    }
}
