package com.example.demo;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Staff extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date joined;

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
            Date joined) {
        super(name, surname, birthDate, title, gender, phone, address);
        this.joined = joined;
    }
}