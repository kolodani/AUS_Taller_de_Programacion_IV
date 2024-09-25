package com.project.autos.persistance.repository;

import com.project.autos.domain.dto.AutoDto;
import com.project.autos.domain.repository.IAutoRepository;
import com.project.autos.persistance.crud.IAutoCrudRepository;
import com.project.autos.persistance.mapper.IAutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AutoRepository implements IAutoRepository {

    private final IAutoCrudRepository iAutoCrudRepository;

    private final IAutoMapper iAutoMapper;

    @Override
    public List<AutoDto> getAll() {
        return iAutoMapper.toAutosDto(iAutoCrudRepository.findAll());
    }

    @Override
    public List<AutoDto> getByIdMarcaAuto(Integer brandCarId) {
        return iAutoMapper.toAutosDto(iAutoCrudRepository.findAllByBrandCarId(brandCarId));
    }

    @Override
    public List<AutoDto> getAutoByPriceLessPriceThan(Double price) {
        return iAutoMapper.toAutosDto(iAutoCrudRepository.findAllByPriceLessThanEqualOrderByPriceAsc(price));
    }

    @Override
    public Optional<AutoDto> getAuto(Integer autoId) {
        return iAutoCrudRepository.findById(autoId).map(iAutoMapper::toAutoDto);
    }

    @Override
    public AutoDto save(AutoDto newAuto) {
        return iAutoMapper.toAutoDto(iAutoCrudRepository.save(iAutoMapper.toAutoEntity(newAuto)));
    }

    @Override
    public void delete(Integer autoId) {
        iAutoCrudRepository.deleteById(autoId);
    }
}
