package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("hello")
    public String hello() {
        return h.hola();
    }

    @GetMapping("usuarios")
    public List<Usuario> getUsuarios(){
        return repo.findAll();
    }

    @PostMapping("usuarios")
    public Usuario saveUser(@RequestBody Usuario user) {
        return repo.save(user);
    }

}

// http://localhost:8080/api/hello
// $ curl http://localhost:8080/usuarios
