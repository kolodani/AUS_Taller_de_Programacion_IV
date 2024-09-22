package com.project.autos.controller;

import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.domain.dto.RespuestaClienteDto;
import com.project.autos.domain.usecase.IClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de clientes
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path= "/clientes")
public class ClienteController {

    private final IClienteUseCase iClienteUseCase;

    /**
     * Devuelve lista de clientes
     * @return HttpCode Ok con lista de clientes
     */
    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll(){
        return ResponseEntity.ok(iClienteUseCase.getAll());
    }

    /**
     * Devuelve un cliente dado su dni
     * @param dni Id del cliente a buscar
     * @return HttpCode Ok si la encuentra, HttpCode Not Found de lo contrario
     */
    @GetMapping(path = "/{dni}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable(name = "dni") Integer dni){
        return ResponseEntity.of(iClienteUseCase.getClienteById(dni));
    }

    /**
     * Devuelve un cliente dado su email
     * @param email del cliente a buscar
     * @return HttpCode Ok si la encuentra, HttpCode Not Found de lo contrario
     */
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<ClienteDto> getClienteByEmail(@PathVariable(name = "email") String email){
        return ResponseEntity.of(iClienteUseCase.getClienteByEmail(email));
    }

    /**
     * Actualiza un cliente
     * @param clienteDtoUpdate cliente actualizado
     * @return HttpCode Ok si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<ClienteDto> update (@RequestBody ClienteDto clienteDtoUpdate) {
        return ResponseEntity.of(iClienteUseCase.update(clienteDtoUpdate));
    }

    /**
     * Elimina un cliente dado su id
     * @param dni del cliente a eliminar
     * @return HttpCode Ok si lo elimina, HttpCode Not Found si no existe
     */
    @DeleteMapping(path = "{dni}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "dni") Integer dni) {
        return new ResponseEntity<>(this.iClienteUseCase.delete(dni) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
