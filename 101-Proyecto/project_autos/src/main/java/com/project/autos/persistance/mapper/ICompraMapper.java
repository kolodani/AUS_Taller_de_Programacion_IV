package com.project.autos.persistance.mapper;

import com.project.autos.domain.dto.CompraRequestDto;
import com.project.autos.persistance.entity.CompraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper de compras
 */
@Mapper(componentModel = "spring", uses = {IAutoCompraMapper.class})
public interface ICompraMapper {

    @Mapping(target = "clienteEntity", ignore = true)
    CompraEntity toCompraEntity(CompraRequestDto compraRequestDto);
}
