package com.project.autos.controller;

import com.project.autos.domain.pojo.MarcaAutoPojo;
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
    public ResponseEntity<List<MarcaAutoPojo>> getAll(){
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
    public ResponseEntity<MarcaAutoPojo> getMarcaAuto(@PathVariable(name = "id") Integer id){
        return ResponseEntity.of(iMarcaAutoService.getMarcaAuto(id));
    }

    /**
     * Crea una nueva marca de auto
     * @param marcaAutoPojoNew marca coche a crear
     * @return HttpCode Created si la guarda correctamente, HttpCode BadRequest de lo contrario
     */
    @PostMapping()
    public ResponseEntity<MarcaAutoPojo> save(@RequestBody MarcaAutoPojo marcaAutoPojoNew){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iMarcaAutoService.save(marcaAutoPojoNew));
        } catch (Exception e) {
            // corregir porque no esta mandando excepciones
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Actualiza una marca de auto
     * @param marcaAutoPojoUpdate Marca de auto actualizada
     * @return HttpCode Ok si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<MarcaAutoPojo> update (@RequestBody MarcaAutoPojo marcaAutoPojoUpdate) {
        return ResponseEntity.of(iMarcaAutoService.update(marcaAutoPojoUpdate));
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
