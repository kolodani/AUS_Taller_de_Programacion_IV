package com.project.autos.persistance.repository;

import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.domain.repository.IClienteRepository;
import com.project.autos.persistance.crud.IClienteCrudRepository;
import com.project.autos.persistance.mapper.IClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ClienteRepository implements IClienteRepository {

    private final IClienteCrudRepository iClienteCrudRepository;

    private final IClienteMapper iClienteMapper;

    @Override
    public List<ClienteDto> getAll() {
        return iClienteMapper.toClientesDto(iClienteCrudRepository.findAll());
    }

    @Override
    public Optional<ClienteDto> getClienteById(Integer dni) {
        return iClienteCrudRepository.findById(dni)
                .map(iClienteMapper::toClienteDto);
    }

    @Override
    public Optional<ClienteDto> getClienteByEmail(String email) {
        return iClienteCrudRepository.findByEmail(email)
                .map(iClienteMapper::toClienteDto);
    }

    @Override
    public ClienteDto save(ClienteDto newCliente) {
        return iClienteMapper.toClienteDto(iClienteCrudRepository.save(iClienteMapper.toClienteEntity(newCliente)));
    }

    @Override
    public void delete(Integer dni) {
        iClienteCrudRepository.deleteById(dni);
    }
}
