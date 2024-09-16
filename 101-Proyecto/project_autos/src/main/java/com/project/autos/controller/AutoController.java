package com.project.autos.controller;

import com.project.autos.domain.dto.AutoDto;
import com.project.autos.domain.usecase.IAutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/autos")
public class AutoController {

    private final IAutoUseCase iAutoUseCase;

    @GetMapping()
    public ResponseEntity<List<AutoDto>> getAll(){
        return ResponseEntity.ok(iAutoUseCase.getAll());
    }

    @GetMapping(path = "/marca-autos/{brandCarId}")
    public ResponseEntity<List<AutoDto>> getByIdMarcaAuto(@PathVariable Integer brandCarId){
        return ResponseEntity.ok(iAutoUseCase.getByIdMarcaAuto(brandCarId));
    }

    @GetMapping(path = "/precio/{price}")
    public ResponseEntity<List<AutoDto>> getAutoByPriceLessPriceThan(@PathVariable Double price){
        return ResponseEntity.ok(iAutoUseCase.getAutoByPriceLessPriceThan(price));
    }

    @GetMapping(path = "/{autoId}")
    public ResponseEntity<AutoDto> getAuto(@PathVariable String autoId){
        return ResponseEntity.of(iAutoUseCase.getAuto(autoId));
    }

    @PostMapping()
    public ResponseEntity<AutoDto> save(@RequestBody AutoDto autoDtoNew){
        return ResponseEntity.status(HttpStatus.CREATED).body(iAutoUseCase.save(autoDtoNew));
    }

    @DeleteMapping(path = "/{autoId}")
    public ResponseEntity<Boolean> delete(@PathVariable String autoId){
        return new ResponseEntity<>(this.iAutoUseCase.delete(autoId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
