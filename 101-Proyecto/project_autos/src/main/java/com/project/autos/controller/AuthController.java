package com.project.autos.controller;

import com.project.autos.domain.dto.AuthClienteDto;
import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.domain.dto.JwtResponseDto;
import com.project.autos.domain.dto.RespuestaClienteDto;
import com.project.autos.domain.usecase.IAuthUseCase;
import com.project.autos.domain.usecase.IClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final IAuthUseCase iAuthUseCase;

    private final IClienteUseCase iClienteUseCase;

    @PostMapping(path = "/register")
    public ResponseEntity<RespuestaClienteDto> save(@RequestBody ClienteDto clienteDtoNew) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iClienteUseCase.save(clienteDtoNew));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthClienteDto authClienteDto) {
        return ResponseEntity.ok(iAuthUseCase.signIn(authClienteDto));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }
}
