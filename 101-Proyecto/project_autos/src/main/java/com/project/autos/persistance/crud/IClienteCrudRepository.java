package com.project.autos.persistance.crud;

import com.project.autos.persistance.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteCrudRepository extends JpaRepository<ClienteEntity, Integer> {

    // Query method
    // @Query("SELECT c FROM ClienteEntity c WHERE c.dni = ?1")
    Optional<ClienteEntity> findByEmail(String email);
}
