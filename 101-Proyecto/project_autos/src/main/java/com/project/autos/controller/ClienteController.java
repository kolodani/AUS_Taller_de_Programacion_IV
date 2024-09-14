package com.project.autos.controller;

import com.project.autos.domain.dto.ClienteDto;
import com.project.autos.domain.dto.RespuestaClienteDto;
import com.project.autos.domain.service.IClienteService;
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

    private final IClienteService iClienteService;

    /**
     * Devuelve lista de clientes
     * @return HttpCode Ok con lista de clientes
     */
    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll(){
        return ResponseEntity.ok(iClienteService.getAll());
    }

    /**
     * Devuelve un cliente dado su dni
     * @param dni Id del cliente a buscar
     * @return HttpCode Ok si la encuentra, HttpCode Not Found de lo contrario
     */
    @GetMapping(path = "/{dni}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable(name = "dni") Integer dni){
        return ResponseEntity.of(iClienteService.getClienteById(dni));
    }

    /**
     * Devuelve un cliente dado su email
     * @param email del cliente a buscar
     * @return HttpCode Ok si la encuentra, HttpCode Not Found de lo contrario
     */
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<ClienteDto> getClienteByEmail(@PathVariable(name = "email") String email){
        return ResponseEntity.of(iClienteService.getClienteByEmail(email));
    }

    /**
     * Crea un nuevo cliente
     * @param clienteDtoNew cliente a crear
     * @return HttpCode Created si la guarda correctamente, HttpCode BadRequest de lo contrario
     */
    @PostMapping()
    public ResponseEntity<RespuestaClienteDto> save(@RequestBody ClienteDto clienteDtoNew){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iClienteService.save(clienteDtoNew));
    }

    /**
     * Actualiza un cliente
     * @param clienteDtoUpdate cliente actualizado
     * @return HttpCode Ok si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<ClienteDto> update (@RequestBody ClienteDto clienteDtoUpdate) {
        return ResponseEntity.of(iClienteService.update(clienteDtoUpdate));
    }

    /**
     * Elimina un cliente dado su id
     * @param dni del cliente a eliminar
     * @return HttpCode Ok si lo elimina, HttpCode Not Found si no existe
     */
    @DeleteMapping(path = "{dni}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "dni") Integer dni) {
        return new ResponseEntity<>(this.iClienteService.delete(dni) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
