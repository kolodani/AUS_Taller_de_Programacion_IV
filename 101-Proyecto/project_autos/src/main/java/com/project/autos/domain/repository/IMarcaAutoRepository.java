package com.project.autos.domain.repository;

import com.project.autos.domain.dto.MarcaAutoDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface del repositorio de marcas de autos
 */
public interface IMarcaAutoRepository {

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return // lista con marca de autos
     */
    List<MarcaAutoDto> getAll();

    /**
     * Devuelve una marca de un coche dada su id
     * @param id Id de marca coche
     * @return Optinal del marca coche encontrado
     */
    Optional<MarcaAutoDto> getMarcaAuto(Integer id);

    /**
     * Guarda una nueva marca de auto
     * @param newMarcaAuto // Marca coche a guarda
     * @return // Marca coche guardada
     */
    MarcaAutoDto save(MarcaAutoDto newMarcaAuto);

    /**
     * Elimina una marca de auto dada su id
     * @param idMarcaAuto // Id de la marca del auto a eliminar
     */
    void delete(Integer idMarcaAuto);
}
