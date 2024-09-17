package com.project.autos.persistance.mapper;

import com.project.autos.domain.dto.AutoCompraRequestDto;
import com.project.autos.persistance.entity.AutoCompraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IAutoCompraMapper {

    @Mapping(source = "codeCar", target = "id.codeCar")
    @Mapping(target = "compraEntity", ignore = true)
    @Mapping(target = "autoEntity", ignore = true)
    @Mapping(target = "id.purchaseNumberBill", ignore = true)
    AutoCompraEntity toAutoCompraEntity(AutoCompraRequestDto autoCompraRequestDto);
}
