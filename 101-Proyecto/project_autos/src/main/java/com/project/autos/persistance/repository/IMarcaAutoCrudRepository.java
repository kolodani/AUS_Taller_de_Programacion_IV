package com.project.autos.persistance.repository;

import com.project.autos.persistance.entity.MarcaAutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaAutoCrudRepository extends JpaRepository<MarcaAutoEntity, Integer> {

}
