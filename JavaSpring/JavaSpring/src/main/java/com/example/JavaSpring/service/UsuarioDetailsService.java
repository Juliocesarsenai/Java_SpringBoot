package com.example.JavaSpring.service;

import com.example.JavaSpring.model.Usuario;
import com.example.JavaSpring.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class UsuarioDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Usuario usuario = usuarioRepository.findByUsername(username)
              .orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado"));
      return User.builder()
              .username(usuario.getUsername())
              .password(usuario.getSenha())
              .roles("USER")
              .build();
    }
}
