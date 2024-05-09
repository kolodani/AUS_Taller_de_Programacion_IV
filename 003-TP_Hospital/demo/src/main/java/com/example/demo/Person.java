package com.example.demo;

import java.sql.Date;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private Date birthDate;
    private String title;
    private String gender;
    private String phone;

    @Embedded
    private Address address;

    public Person() {
    }

    public Person(
            String name,
            String surname,
            Date birthDate,
            String title,
            String gender,
            String phone,
            Address address) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.title = title;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }
}
