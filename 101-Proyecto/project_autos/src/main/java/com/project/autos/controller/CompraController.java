package com.project.autos.controller;

import com.project.autos.domain.dto.CompraBillResponseDto;
import com.project.autos.domain.dto.CompraRequestDto;
import com.project.autos.domain.dto.CompraResponseDto;
import com.project.autos.domain.usecase.ICompraUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/compras")
public class CompraController {

    private final ICompraUseCase iCompraUseCase;

    @GetMapping()
    public ResponseEntity<List<CompraResponseDto>> getAll() {
        return ResponseEntity.ok(iCompraUseCase.getAll());
    }

    @GetMapping(path = "/clientes/{dni}")
    public ResponseEntity<List<CompraResponseDto>> getClienteById(@PathVariable Integer dni) {
        return ResponseEntity.ok(iCompraUseCase.getByIdCliente(dni));
    }

    @GetMapping(path = "/{numberBill}")
    public ResponseEntity<CompraResponseDto> getCompraByNumberBill(@PathVariable Integer numberBill) {
        return ResponseEntity.ok(iCompraUseCase.getByNumberBill(numberBill));
    }

    @PostMapping
    public ResponseEntity<CompraBillResponseDto> savePurchase(@RequestBody CompraRequestDto compraRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCompraUseCase.save(compraRequestDto));
    }
}
