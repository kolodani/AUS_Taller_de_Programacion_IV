package com.project.autos.domain.service;

import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.domain.dto.RespuestaClienteDto;
import com.project.autos.domain.repository.IClienteRepository;
import com.project.autos.domain.usecase.IClienteUseCase;
import com.project.autos.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteUseCase {

    private final IClienteRepository iClienteRepository;

    @Override
    public List<ClienteDto> getAll() {
        return iClienteRepository.getAll();
    }

    @Override
    public Optional<ClienteDto> getClienteById(Integer dni) {
        return iClienteRepository.getClienteById(dni);
    }

    @Override
    public Optional<ClienteDto> getClienteByEmail(String email) {
        return iClienteRepository.getClienteByEmail(email);
    }

    @Override
    public RespuestaClienteDto save(ClienteDto newCliente) {

        if (!newCliente.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }
        String passwordGenerated = generateRandomPassword(8);
        newCliente.setPassword(passwordGenerated);
        newCliente.setActive(1);
        iClienteRepository.save(newCliente);

        return new RespuestaClienteDto(passwordGenerated);
    }

    @Override
    public Optional<ClienteDto> update(ClienteDto modifyCliente) {
        if(iClienteRepository.getClienteById(modifyCliente.getDni()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iClienteRepository.save(modifyCliente));
    }

    @Override
    public boolean delete(Integer dni) {
        if (iClienteRepository.getClienteById(dni).isEmpty()){
            return false;
        }
        iClienteRepository.delete(dni);
        return true;
    }

    // Metodo para generar una contraseña alfanumerica aleatoria de una longitud especifica
    private String generateRandomPassword(int len){
        // Rango ASCCI - alfanumerico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // cada iteracion del bucle elige aleatoriamente un caracter del dado
        // rango ASCII y lo agrega a la instancia ´StringBuilder´
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
