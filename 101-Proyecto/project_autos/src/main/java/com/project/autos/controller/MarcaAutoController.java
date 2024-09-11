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

    @GetMapping
    public ResponseEntity<List<MarcaAutoPojo>> getAll(){
        return ResponseEntity.ok(iMarcaAutoService.getAll());
        // return ResponseEntity.status(HttpStatus.OK)
        //      .body(iMarcaAutoService.getAll());

        // return new ResponseEntity<>(iMarcaAutoService.getAll(), HttpStatus.OK);
        // Alternativas para crea RESPONSE_ENTITY
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MarcaAutoPojo> getMarcaAuto(@PathVariable Integer id){
        return ResponseEntity.of(iMarcaAutoService.getMarcaAuto(id));
    }

    @PostMapping()
    public ResponseEntity<MarcaAutoPojo> save(@RequestBody MarcaAutoPojo marcaAutoPojoNew){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iMarcaAutoService.save(marcaAutoPojoNew));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
