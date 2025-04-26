package com.example.JavaSpring.service;

import com.example.JavaSpring.model.Usuario;
import com.example.JavaSpring.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;




import com.example.JavaSpring.model.Usuario;
import com.example.JavaSpring.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario registrarUsuario(String nome, String cpf, String rg, String senha){
        String senhaCriptografada = passwordEncoder.encode(senha);
        Usuario usuario = new Usuario(nome, cpf, rg, senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarios(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario salvarUsuario(@Valid Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizar(@Valid Usuario usuario) {
        Usuario usuarioAtualizar = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioAtualizar.setUsername(usuario.getUsername());
        usuarioAtualizar.setCpf(usuario.getCpf());
        usuarioAtualizar.setRg(usuario.getRg());

        return usuarioRepository.save(usuarioAtualizar);
    }
}