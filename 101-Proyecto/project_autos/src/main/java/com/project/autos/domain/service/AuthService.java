package com.project.autos.domain.service;

import com.project.autos.domain.dto.AuthClienteDto;
import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.domain.dto.JwtResponseDto;
import com.project.autos.domain.repository.IClienteRepository;
import com.project.autos.domain.usecase.IAuthUseCase;
import com.project.autos.security.JwtAuthenticationProvider;
import com.project.autos.exception.CustomerNotExistException;
import com.project.autos.exception.PasswordIncorrectException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService implements IAuthUseCase {

    private final IClienteRepository iClienteRepository;

    /**
     * Clase que administra los JWTs
     */
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Clase que encripta contraseñas
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Devuelve un dto con el jwt del usuario dadas unas credenciales
     * @param authClienteDto Credenciales de acceso
     * @return Dto con el jwt del usuario si las credenciales son validas
     */
    public JwtResponseDto signIn(AuthClienteDto authClienteDto) {

        Optional<ClienteDto> customer = iClienteRepository.getClienteByEmail(authClienteDto.getEmail());

        if (customer.isEmpty()) {
            throw new CustomerNotExistException();
        }

        if (!passwordEncoder.matches(authClienteDto.getPassword(), customer.get().getPassword())) {
            throw new PasswordIncorrectException();
        }
        
        return new JwtResponseDto(jwtAuthenticationProvider.createToken(customer.get()));
    }

    /**
     * Cierra la sesión eliminando de la lista blanca el token ingresado
     * @param token Token a eliminar
     * @return
     */
    public JwtResponseDto signOut(String token) {

        String[] authElements = token.split(" ");
        return new JwtResponseDto(jwtAuthenticationProvider.deleteToken(authElements[1]));
    }

}
