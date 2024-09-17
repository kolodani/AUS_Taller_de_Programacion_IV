package com.project.autos.persistance.crud;

import com.project.autos.persistance.entity.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICompraCrudRepository extends JpaRepository<CompraEntity, Integer> {
    List<CompraEntity> findAllByCardIdDate(Integer id);
}
