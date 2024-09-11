package com.project.autos.persistance.repository;

import com.project.autos.domain.pojo.MarcaAutoPojo;
import com.project.autos.domain.repository.IMarcaAutoRepository;
import com.project.autos.persistance.entity.MarcaAutoEntity;
import com.project.autos.persistance.mapper.IMarcaAutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor // Crea constructor con los atributos final
@Repository
public class MarcaAutoRepository implements IMarcaAutoRepository {

    /**
     * Crud de marca coche
     */
    private final IMarcaAutoCrudRepository iMarcaAutoCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final IMarcaAutoMapper iMarcaAutoMapper;

    /**
     * Devuelve una lista con todas las marcas de autos
     * @return // Lista con marcas de autos
     */
    @Override
    public List<MarcaAutoPojo> getAll() {
        return iMarcaAutoMapper.toMarcasAutosPojo(iMarcaAutoCrudRepository.findAll());
    }

    /**
     * Devuelve una marca de un coche dada su id
     * @param id // Id de marca coche
     * @return // Optinal del marca coche encontrado
     */
    @Override
    public Optional<MarcaAutoPojo> getMarcaAuto(Integer id) {
        return iMarcaAutoCrudRepository.findById(id)
                .map(iMarcaAutoMapper::toMarcaAutoPojo); // Metodo por referencia
        //      marcaAutoEntity -> iMarcaAutoMapper.toMarcaAutoPojo(marcaAutoEntity
        // Cambio a la recomendacion pero lo que hago originalmente es la funcion lambda
    }

    /**
     * Guarda una nueva marca de auto
     * @param newMarcaAuto // Marca coche a guarda
     * @return // Marca coche guardada
     */
    @Override
    public MarcaAutoPojo save(MarcaAutoPojo newMarcaAuto) {
        MarcaAutoEntity marcaAutoEntity = iMarcaAutoMapper.toMarcaAutoEntity(newMarcaAuto);
        return iMarcaAutoMapper.toMarcaAutoPojo(iMarcaAutoCrudRepository.save(marcaAutoEntity));
    }

    /**
     * Elimina una marca de auto dada su id
     * @param idMarcaAuto // Id de la marca del auto a eliminar
     */
    @Override
    public void delete(Integer idMarcaAuto) {
        iMarcaAutoCrudRepository.deleteById(idMarcaAuto);
    }
}
