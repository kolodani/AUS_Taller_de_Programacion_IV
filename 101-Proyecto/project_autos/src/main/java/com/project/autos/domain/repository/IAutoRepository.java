package com.project.autos.domain.repository;

import com.project.autos.domain.dto.AutoDto;

import java.util.List;
import java.util.Optional;

public interface IAutoRepository {

    List<AutoDto> getAll();

    List<AutoDto> getByIdMarcaAuto(Integer brandCarId);

    List<AutoDto> getAutoByPriceLessPriceThan(Double price);

    Optional<AutoDto> getAuto(String autoId);

    AutoDto save(AutoDto newAuto);

    void delete(String autoId);
}
