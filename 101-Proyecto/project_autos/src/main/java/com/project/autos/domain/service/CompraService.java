package com.project.autos.domain.service;

import com.project.autos.domain.dto.AutoDto;
import com.project.autos.domain.dto.CompraBillResponseDto;
import com.project.autos.domain.dto.CompraRequestDto;
import com.project.autos.domain.dto.CompraResponseDto;
import com.project.autos.domain.repository.IAutoRepository;
import com.project.autos.domain.repository.ICompraRepository;
import com.project.autos.domain.usecase.ICompraUseCase;
import com.project.autos.exception.PurchaseNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompraService implements ICompraUseCase {

    private final ICompraRepository iCompraRepository;

    private final IAutoRepository iAutoRepository;

    @Override
    public List<CompraResponseDto> getAll() {
        return iCompraRepository.getAll();
    }

    @Override
    public List<CompraResponseDto> getByIdCliente(Integer dni) {
        return iCompraRepository.getByIdCliente(dni);
    }

    @Override
    public CompraResponseDto getByNumberBill(Integer numberBill) {
        CompraResponseDto compraResponseDto = iCompraRepository.getByNumberBill(numberBill);

        if (compraResponseDto == null) {
            throw new PurchaseNotExistException();
        }

        return compraResponseDto;
    }

    @Override
    public CompraBillResponseDto save(CompraRequestDto compraRequestDto) {
        CompraBillResponseDto compraBillResponseDto = iCompraRepository.save(compraRequestDto);

        compraRequestDto.getCarsPurchase().forEach(carPurchase -> {
            AutoDto carActual = iAutoRepository.getAuto(carPurchase.getCodeCar()).get();

            carActual.setStock(carActual.getStock() - carPurchase.getQuantity());

            iAutoRepository.save(carActual);
        });

        return compraBillResponseDto;
    }
}
