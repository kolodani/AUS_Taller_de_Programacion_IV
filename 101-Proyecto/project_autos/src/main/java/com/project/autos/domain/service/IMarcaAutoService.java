package com.project.autos.domain.service;

import com.project.autos.domain.pojo.MarcaAutoPojo;

import java.util.List;
import java.util.Optional;

public interface IMarcaAutoService {

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return // lista con marca de autos
     */
    List<MarcaAutoPojo> getAll();

    /**
     * Devuelve una marca de un coche dada su id
     * @param id Id de marca coche
     * @return Optinal del marca coche encontrado
     */
    Optional<MarcaAutoPojo> getMarcaAuto(Integer id);

    /**
     * Guarda una nueva marca de auto
     * @param newMarcaAuto // Marca coche a guarda
     * @return // Marca coche guardada
     */
    MarcaAutoPojo save(MarcaAutoPojo newMarcaAuto);

    /**
     * Elimina una marca de auto dada su id
     * @param idMarcaAuto // Id de la marca del auto a eliminar
     * @return // True si se elimino, false de lo contrario
     */
    boolean delete(Integer idMarcaAuto);
}
