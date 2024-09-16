package com.project.autos.persistance.mapper;

import com.project.autos.domain.dto.CompraRequestDto;
import com.project.autos.persistance.entity.CompraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper de compras
 */
@Mapper(componentModel = "spring")
public interface ICompraMapper {

    CompraRequestDto toCompraRequestDto(CompraEntity compraEntity);

    @Mapping(target = "clienteEntity", ignore = true)
    CompraEntity toCompraEntity(CompraRequestDto compraRequestDto);

    List<CompraRequestDto> toComprasDto(List<CompraEntity> comprasEntities);
}
