package com.example.demo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    public String street;
    public String number;
    public String city;
}
