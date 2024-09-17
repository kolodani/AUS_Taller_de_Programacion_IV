package com.project.autos.domain.repository;

import com.project.autos.domain.dto.CompraBillResponseDto;
import com.project.autos.domain.dto.CompraRequestDto;
import com.project.autos.domain.dto.CompraResponseDto;

import java.util.List;

public interface ICompraRepository {

    List<CompraResponseDto> getAll();

    List<CompraResponseDto> getByIdCliente(Integer dni);

    CompraResponseDto getByNumberBill(Integer numberBill);

    CompraBillResponseDto save(CompraRequestDto compraRequestDto);
}
