package com.project.autos.persistance.mapper;

import com.project.autos.domain.dto.MarcaAutoDto;
import com.project.autos.persistance.entity.MarcaAutoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de marcaCoches a pojos o entidades
 */

@Mapper(componentModel = "spring")
public interface IMarcaAutoMapper {

    /**
     * Convierte una entidad a un pojo de marca auto
     * @param marcaEntity // Entidad a convertir
     * @return // Pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaAutoDto toMarcaAutoDto(MarcaAutoEntity marcaEntity);

    /**
     * Convertir un pojo a una entidad de marca auto
     * @param marcaPojo // Pojo a convertir
     * @return // Entity convertido
     */
    @InheritInverseConfiguration
    @Mapping(target = "carEntities", ignore = true)
    MarcaAutoEntity toMarcaAutoEntity(MarcaAutoDto marcaPojo);

    /**
     * Retorna una lista de marcas autos transformada a pojo de una lista de entidades
     * @param marcasCocheEntity // Entidad a transformar
     * @return // Lista transformada
     */
    List<MarcaAutoDto> toMarcasAutosDto(List<MarcaAutoEntity> marcasCocheEntity);
}
