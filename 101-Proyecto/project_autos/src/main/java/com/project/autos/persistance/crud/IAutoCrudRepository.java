package com.project.autos.persistance.crud;

import com.project.autos.persistance.entity.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAutoCrudRepository extends JpaRepository<AutoEntity, Integer> {

    List<AutoEntity> findAllByBrandCarId(Integer brandCarId);

    List<AutoEntity> findAllByPriceLessThanEqualOrderByPriceAsc(Double price);
}
