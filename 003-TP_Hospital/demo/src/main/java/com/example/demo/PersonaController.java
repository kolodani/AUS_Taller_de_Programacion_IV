package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("salud")
@RestController
public class PersonaController {

    @Autowired
    private Hola h;
    @Autowired
    private PersonaRepository repo;

    @GetMapping("hi")
    public String hello() {
        return h.hola();
    }

    // Devuelve todas las personas
    // http://localhost:8080/salud/personas
    // curl http://localhost:8080/salud/personas
    @GetMapping("personas")
    public List<Persona> getPersonas() {
        return repo.findAll();
    }

    // devuelve una persona
    // http://localhost:8080/salud/personas/1
    // curl http://localhost:8080/salud/personas/1
    @GetMapping("personas/{id}")
    public Persona getPersona(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    // borro todas las personas
    // curl -X DELETE http://localhost:8080/salud/personas
    @DeleteMapping("personas")
    public void deleteAllPersonas() {
        repo.deleteAll();
    }

    // borro un usuario por id
    // curl -X DELETE http://localhost:8080/salud/personas/1
    @DeleteMapping("personas/{id}")
    public void deletePersonas(@PathVariable("id") Long id) {
        repo.deleteById(id);
    }

    // guardo una persona
    // curl -X POST -H "Content-Type: application/json" -d '{"nombre":"Juan"}'
    @PostMapping("personas")
    public Persona savePersona(@RequestBody Persona persona) {
        return repo.save(persona);
    }
}
