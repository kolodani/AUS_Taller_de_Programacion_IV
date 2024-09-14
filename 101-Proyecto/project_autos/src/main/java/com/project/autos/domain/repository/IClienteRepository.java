package com.project.autos.domain.repository;

import com.project.autos.domain.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface del Repositorio de Clientes
 */
public interface IClienteRepository {

    /**
     * Devuelve una lista con todos los clientes
     * @return // lista con clientes
     */
    List<ClienteDto> getAll();

    /**
     * Devuelve una cliente dada su id
     * @param dni dni del cliente
     * @return Optinal del cliente encontrado
     */
    Optional<ClienteDto> getClienteById(Integer dni);

    /**
     * Devuelve una cliente dada su id
     * @param email del cliente
     * @return Optinal del cliente encontrado
     */
    Optional<ClienteDto> getClienteByEmail(String email);

    /**
     * Guarda un nuevo cliente
     * @param newCliente Cliente a guarda
     * @return cliente guardado
     */
    ClienteDto save(ClienteDto newCliente);

    /**
     * Elimina un cliente dada su dni
     * @param dni dni del cliente a eliminar
     */
    void delete(Integer dni);
}
