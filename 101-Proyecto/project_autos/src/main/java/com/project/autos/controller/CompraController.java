package com.project.autos.controller;

import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.domain.usecase.IClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/compras")
public class CompraController {

    private final IClienteUseCase iClienteUseCase;

    @GetMapping()
    public ResponseEntity<List<ClienteDto>> getAll() {
        return ResponseEntity.ok(iClienteUseCase.getAll());
    }

    @GetMapping(path = "/{dni}")
    public ResponseEntity<ClienteDto> getCustomerByCardId(@PathVariable Integer dni) {
        return ResponseEntity.of(iClienteUseCase.getClienteById(dni));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<ClienteDto> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iClienteUseCase.getClienteByEmail(email));
    }

    @PatchMapping
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto customerDtoUpdate) {
        return ResponseEntity.of(iClienteUseCase.update(customerDtoUpdate));
    }

    @DeleteMapping(path = "/{dni}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer dni) {
        return new ResponseEntity<>(this.iClienteUseCase.delete(dni) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
