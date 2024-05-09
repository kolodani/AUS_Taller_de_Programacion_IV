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
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int age;
    private Date Accepted;
    private String sickness;

    @ManyToMany
    private Set<Allergies> allergies;

    public Patient() {
    }

    public Patient(
            String name,
            String surname,
            Date birthDate,
            String title,
            String gender,
            String phone,
            Address address,
            int age,
            Date Accepted,
            String sickness) {
        super(name, surname, birthDate, title, gender, phone, address);
        this.age = age;
        this.Accepted = Accepted;
        this.sickness = sickness;

    }

}
