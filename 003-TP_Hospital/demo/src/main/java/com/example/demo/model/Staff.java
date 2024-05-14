package com.example.demo.model;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Staff extends Person{

    private Date joinedHospital;

    @ManyToMany
    private Set<Certificate> certificates;

    public Staff() {
    }

    public Staff(
            String name,
            String surname,
            Date birthDate,
            String title,
            String gender,
            String phone,
            Address address,
            Date joinedHospital) {
        super(name, surname, birthDate, title, gender, phone, address);
        this.joinedHospital = joinedHospital;
    }
}