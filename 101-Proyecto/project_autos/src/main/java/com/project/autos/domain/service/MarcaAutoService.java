package com.project.autos.domain.service;

import com.project.autos.domain.pojo.MarcaAutoPojo;
import com.project.autos.domain.repository.IMarcaAutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicion de marcas de autos
 */
@RequiredArgsConstructor
@Service
public class MarcaAutoService implements IMarcaAutoService{

    /**
     * Repositorio de marca coche
     */
    private final IMarcaAutoRepository iMarcaAutoRepository;

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return // lista con marca de autos
     */
    @Override
    public List<MarcaAutoPojo> getAll() {
        return iMarcaAutoRepository.getAll();
    }

    /**
     * Devuelve una marca de un coche dada su id
     * @param id Id de marca coche
     * @return Optinal del marca coche encontrado
     */
    @Override
    public Optional<MarcaAutoPojo> getMarcaAuto(Integer id) {
        return iMarcaAutoRepository.getMarcaAuto(id);
    }

    /**
     * Guarda una nueva marca de auto
     * @param newMarcaAuto // Marca coche a guarda
     * @return // Marca coche guardada
     */
    @Override
    public MarcaAutoPojo save(MarcaAutoPojo newMarcaAuto) {
        return iMarcaAutoRepository.save(newMarcaAuto);
    }

    /**
     * Actualiza una marca de auto
     * @param newMarcaAuto Marca de auto a actualizar
     * @return Optional con marca de autos actualizada
     */
    @Override
    public Optional<MarcaAutoPojo> update(MarcaAutoPojo newMarcaAuto) {
        if (iMarcaAutoRepository.getMarcaAuto(newMarcaAuto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iMarcaAutoRepository.save(newMarcaAuto));
    }

    /**
     * Elimina una marca de auto dada su id
     * @param idMarcaAuto // Id de la marca del auto a eliminar
     * @return // True si se elimino, false de lo contrario
     */
    @Override
    public boolean delete(Integer idMarcaAuto) {

        if (iMarcaAutoRepository.getMarcaAuto(idMarcaAuto).isEmpty()){
            return false;
        }
        iMarcaAutoRepository.delete(idMarcaAuto);
        return true;
    }
}





