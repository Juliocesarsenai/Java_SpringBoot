package com.example.Spring_Boot_Aula.controller;

import com.example.Spring_Boot_Aula.model.User;
import com.example.Spring_Boot_Aula.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return usuarioService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        usuarioService.salvar(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);


    }

    @PutMapping
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        usuarioService.atualizar(user);
        return ResponseEntity.ok(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }


}

