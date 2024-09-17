package com.project.autos.persistance.repository;

import com.project.autos.domain.dto.AutoCompraResponseDto;
import com.project.autos.domain.dto.CompraBillResponseDto;
import com.project.autos.domain.dto.CompraRequestDto;
import com.project.autos.domain.dto.CompraResponseDto;
import com.project.autos.domain.repository.ICompraRepository;
import com.project.autos.persistance.crud.ICompraCrudRepository;
import com.project.autos.persistance.entity.CompraEntity;
import com.project.autos.persistance.mapper.ICompraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CompraRepository implements ICompraRepository {

    private final ICompraCrudRepository iCompraCrudRepository;

    private final ICompraMapper iCompraMapper;

    @Override
    public List<CompraResponseDto> getAll() {

        List<CompraEntity> listCompraEntity = iCompraCrudRepository.findAll();
        List<CompraResponseDto> listCompraResponseDto = new ArrayList<>();

        listCompraEntity.forEach(compraEntity -> listCompraResponseDto.add(toPurchaseResponseDtoByEntity(compraEntity)));

        return listCompraResponseDto;
    }

    @Override
    public List<CompraResponseDto> getByIdCliente(Integer dni) {
        List<CompraEntity> listPurchasesEntity = iCompraCrudRepository.findAllByCardIdDate(dni);
        List<CompraResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchasesEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    @Override
    public CompraResponseDto getByNumberBill(Integer numberBill) {
        Optional<CompraEntity> purchaseEntitySearch = iCompraCrudRepository.findById(numberBill);

        if(purchaseEntitySearch.isEmpty()) {
            return null;
        }

        return toPurchaseResponseDtoByEntity(purchaseEntitySearch.get());
    }

    @Override
    public CompraBillResponseDto save(CompraRequestDto compraRequestDto) {
        CompraEntity compraEntity = iCompraMapper.toCompraEntity(compraRequestDto);

        compraEntity.getCarsPurchase().forEach(carPurchaseEntity -> carPurchaseEntity.setCompraEntity(compraEntity));

        CompraEntity purchaseEntitySave = iCompraCrudRepository.save(compraEntity);
        return new CompraBillResponseDto(purchaseEntitySave.getNumberBill());
    }

    public CompraResponseDto toPurchaseResponseDtoByEntity(CompraEntity compraEntity) {
        CompraResponseDto compraResponseDto = new CompraResponseDto();
        compraResponseDto.setNumberBill(compraEntity.getNumberBill());
        compraResponseDto.setCardIdDate(compraEntity.getCardIdDate());
        compraResponseDto.setDate(compraEntity.getDate());
        compraResponseDto.setTotal(compraEntity.getTotal());
        compraResponseDto.setPaymentMethod(compraEntity.getPaymentMethod());

        List<AutoCompraResponseDto> carPurchaseResponseDtoList = new ArrayList<>();
        compraEntity.getCarsPurchase().forEach(carPurchaseEntity -> {
            String reference = carPurchaseEntity.getAutoEntity().getReference();
            Integer quantity = carPurchaseEntity.getQuantity();
            Integer total = carPurchaseEntity.getTotal();
            carPurchaseResponseDtoList.add(new AutoCompraResponseDto(reference, quantity, total));
        });

        compraResponseDto.setCarsPurchase(carPurchaseResponseDtoList);

        return compraResponseDto;
    }
}
