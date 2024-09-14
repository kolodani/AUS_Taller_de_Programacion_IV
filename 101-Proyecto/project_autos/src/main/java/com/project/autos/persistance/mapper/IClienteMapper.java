package com.project.autos.persistance.mapper;

import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.persistance.entity.ClienteEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper de cliente
 */
@Mapper(componentModel = "spring")
public interface IClienteMapper {

    ClienteDto toClienteDto(ClienteEntity clienteEntity);

    ClienteEntity toClienteEntity(ClienteDto clienteDto);

    List<ClienteDto> toClientesDto(List<ClienteEntity> clienteEntityList);
}