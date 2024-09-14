package com.project.autos.persistance.mapper;

import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.persistance.entity.ClienteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-14T14:16:16-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class IClienteMapperImpl implements IClienteMapper {

    @Override
    public ClienteDto toClienteDto(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }

        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setDni( clienteEntity.getDni() );
        clienteDto.setFullName( clienteEntity.getFullName() );
        clienteDto.setEmail( clienteEntity.getEmail() );
        clienteDto.setNumberCellphone( clienteEntity.getNumberCellphone() );
        clienteDto.setActive( clienteEntity.getActive() );
        clienteDto.setPassword( clienteEntity.getPassword() );

        return clienteDto;
    }

    @Override
    public ClienteEntity toClienteEntity(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setDni( clienteDto.getDni() );
        clienteEntity.setFullName( clienteDto.getFullName() );
        clienteEntity.setEmail( clienteDto.getEmail() );
        clienteEntity.setNumberCellphone( clienteDto.getNumberCellphone() );
        clienteEntity.setActive( clienteDto.getActive() );
        clienteEntity.setPassword( clienteDto.getPassword() );

        return clienteEntity;
    }

    @Override
    public List<ClienteDto> toClientesDto(List<ClienteEntity> clienteEntityList) {
        if ( clienteEntityList == null ) {
            return null;
        }

        List<ClienteDto> list = new ArrayList<ClienteDto>( clienteEntityList.size() );
        for ( ClienteEntity clienteEntity : clienteEntityList ) {
            list.add( toClienteDto( clienteEntity ) );
        }

        return list;
    }
}
