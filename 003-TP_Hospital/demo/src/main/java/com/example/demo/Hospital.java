package com.example.demo;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phone;

    @Embedded
    private Address address;

    private Department[] departments;

    public Hospital() {
    }

    public Hospital(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}

