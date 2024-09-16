package com.project.autos.persistance.mapper;

import com.project.autos.domain.dto.AutoDto;
import com.project.autos.persistance.entity.AutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAutoMapper {

    AutoDto toAutoDto(AutoEntity autoEntity);

    @Mapping(target = "brandCarEntity", ignore = true)
    @Mapping(target = "autoCompraEntity", ignore = true)
    AutoEntity toAutoEntity(AutoDto autoDto);

    List<AutoDto> toAutosDto(List<AutoEntity> autoEntityList);
}
