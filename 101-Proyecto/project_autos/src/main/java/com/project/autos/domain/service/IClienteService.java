package com.project.autos.domain.service;

import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.domain.dto.RespuestaClienteDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio de cliente
 */
public interface IClienteService {
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
    RespuestaClienteDto save(ClienteDto newCliente);

    /**
     * Actualiza un cliente
     * @param modifyCliente cliente a actualizar
     * @return cliente actualizado
     */
    Optional<ClienteDto> update(ClienteDto modifyCliente);

    /**
     * Elimina un cliente dada su dni
     * @param dni dni del cliente a eliminar
     */
    boolean delete(Integer dni);
}
