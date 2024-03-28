package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class HolaComponente implements Hola {
    public String hola(){
        return "hola componente";
    }
}
