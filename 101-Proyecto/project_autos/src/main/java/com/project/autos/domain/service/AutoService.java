package com.project.autos.domain.service;

import com.project.autos.domain.dto.AutoDto;
import com.project.autos.domain.repository.IAutoRepository;
import com.project.autos.domain.usecase.IAutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AutoService implements IAutoUseCase {

    private final IAutoRepository iAutoRepository;

    @Override
    public List<AutoDto> getAll() {
        return iAutoRepository.getAll();
    }

    @Override
    public List<AutoDto> getByIdMarcaAuto(Integer brandCarId) {
        return iAutoRepository.getByIdMarcaAuto(brandCarId);
    }

    @Override
    public List<AutoDto> getAutoByPriceLessPriceThan(Double price) {
        return iAutoRepository.getAutoByPriceLessPriceThan(price);
    }

    @Override
    public Optional<AutoDto> getAuto(String autoId) {
        return iAutoRepository.getAuto(autoId);
    }

    @Override
    public AutoDto save(AutoDto newAuto) {
        return iAutoRepository.save(newAuto);
    }

    @Override
    public boolean delete(String autoId) {
        if (iAutoRepository.getAuto(autoId).isEmpty()){
            return false;
        }
        iAutoRepository.delete(autoId);
        return true;
    }
}
