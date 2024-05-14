package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Allergies;

public interface AllergiesRepository extends JpaRepository<Allergies, Long> {

}
