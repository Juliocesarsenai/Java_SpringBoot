package com.example.JavaSpring.controller;

import com.example.JavaSpring.model.Usuario;
import com.example.JavaSpring.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("{id}")
    public Optional<Usuario> buscarUsuarios(@PathVariable Long id){
        return usuarioService.buscarUsuarios(id);
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id,@RequestBody Usuario usuario){
        usuario.setId(id);
        return usuarioService.atualizar(usuario);
    }

    @DeleteMapping("{id}" +
            "")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }

}
