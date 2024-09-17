package com.project.autos.domain.usecase;

import com.project.autos.domain.dto.AuthClienteDto;
import com.project.autos.domain.dto.JwtResponseDto;

public interface IAuthUseCase {

    JwtResponseDto signIn(AuthClienteDto authClienteDto);

    JwtResponseDto signOut(String jwt);
}
