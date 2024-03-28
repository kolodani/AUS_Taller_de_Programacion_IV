package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api")
@RestController
public class HelloController {

    @Autowired
    private Hola h;

    @GetMapping("hello")
    public String hello() {
        return h.hola();
    }
}

// http://localhost:8080/api/hello
