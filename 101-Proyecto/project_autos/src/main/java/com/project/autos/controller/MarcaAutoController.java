package com.project.autos.controller;

import com.project.autos.domain.dto.MarcaAutoDto;
import com.project.autos.domain.service.IMarcaAutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de Marcas de autos
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-autos")
public class MarcaAutoController {

    /**
     * Servicio de marca coche
     */
    private final IMarcaAutoService iMarcaAutoService;

    /**
     * Devuelve lista de marcas de autos
     * @return HttpCode Ok con lista de marcas de autos
     */
    @GetMapping
    public ResponseEntity<List<MarcaAutoDto>> getAll(){
        return ResponseEntity.ok(iMarcaAutoService.getAll());
        // return ResponseEntity.status(HttpStatus.OK)
        //      .body(iMarcaAutoService.getAll());

        // return new ResponseEntity<>(iMarcaAutoService.getAll(), HttpStatus.OK);
        // Alternativas para crea RESPONSE_ENTITY
    }

    /**
     * Devuelve una marca del auto dado su id
     * @param id Id de la marca coche a buscar
     * @return HttpCode Ok si la encuentra, HttpCode Not Found de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<MarcaAutoDto> getMarcaAuto(@PathVariable(name = "id") Integer id){
        return ResponseEntity.of(iMarcaAutoService.getMarcaAuto(id));
    }

    /**
     * Crea una nueva marca de auto
     * @param marcaAutoDtoNew marca coche a crear
     * @return HttpCode Created si la guarda correctamente, HttpCode BadRequest de lo contrario
     */
    @PostMapping()
    public ResponseEntity<MarcaAutoDto> save(@RequestBody MarcaAutoDto marcaAutoDtoNew){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iMarcaAutoService.save(marcaAutoDtoNew));
        } catch (Exception e) {
            // corregir porque no esta mandando excepciones
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Actualiza una marca de auto
     * @param marcaAutoDtoUpdate Marca de auto actualizada
     * @return HttpCode Ok si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<MarcaAutoDto> update (@RequestBody MarcaAutoDto marcaAutoDtoUpdate) {
        return ResponseEntity.of(iMarcaAutoService.update(marcaAutoDtoUpdate));
    }

    /**
     * Elimina una marca cooche dado su id
     * @param id Id de la marca coche a eliminar
     * @return HttpCode Ok si lo elimina, HttpCode Not Found si no existe
     */
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(this.iMarcaAutoService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
