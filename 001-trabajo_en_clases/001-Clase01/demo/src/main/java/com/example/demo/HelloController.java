package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@RequestMapping("api")
@RestController
public class HelloController {

    @Autowired
    private Hola h;
    @Autowired
    private UsuarioRepository repo;

    // http://localhost:8080/api/hello
    // curl http://localhost:8080/api/hello
    @GetMapping("hello")
    public String hello() {
        return h.hola();
    }

    // devuelvo todos los usuarios
    // http://localhost:8080/api/usuarios
    // curl http://localhost:8080/api/usuarios
    @GetMapping("usuarios")
    public List<Usuario> getUsuarios(){
        return repo.findAll();
    }

    // devuelvo un usuario
    // http://localhost:8080/api/usuarios/1
    // curl http://localhost:8080/api/usuarios/1
    @GetMapping("usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        return repo.findById(id).get();
    }

    // guardo un usuario
    // http://localhost:8080/api/usuarios
    // curl -X POST -H "Content-Type: application/json" -d '{"nombre":"Juan"}' http://localhost:8080/api/usuarios
    @PostMapping("usuarios")
    public Usuario saveUser(@RequestBody Usuario user) {
        return repo.save(user);
    }

    // borro un usuario por id
    // curl -X DELETE http://localhost:8080/api/usuarios/1
    @DeleteMapping("usuarios/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        repo.deleteById(id);
    }

    // borro todos los usuarios
    // curl -X DELETE http://localhost:8080/api/usuarios
    @DeleteMapping("usuarios")
    public void deleteAllUsers() {
        repo.deleteAll();
    }

    // crear un usuario con datos de prueba
    // curl -X POST http://localhost:8080/api/usuarios/test
    @PostMapping("usuarios/test")
    public void test() {
        repo.save(new Usuario("juan", "123", "jlopez@hotmail.com", true));
    }
}

