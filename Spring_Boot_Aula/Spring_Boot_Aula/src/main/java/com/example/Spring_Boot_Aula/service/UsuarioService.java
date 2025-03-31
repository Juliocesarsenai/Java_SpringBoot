package com.example.Spring_Boot_Aula.service;

import com.example.Spring_Boot_Aula.model.User;
import com.example.Spring_Boot_Aula.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.autoconfigure.container.ContainerImageMetadata.isPresent;

@Service
@Validated
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void saveUser(@RequestBody User user) {
        usuarioRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return usuarioRepository.findById(id);
    }

    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public User salvar(@Valid User user) {
        if (usuarioRepository.findById(user.getId()).isPresent()) {
            return usuarioRepository.save(user);
        }
        return usuarioRepository.save(user);
    }

    public User atualizar(@Valid User user) {
        User userAtualizar = usuarioRepository.findById(user.getId())
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
        userAtualizar.setName(user.getName());
        userAtualizar.setEmail(user.getEmail());
        userAtualizar.setSenha(user.getSenha());

        return usuarioRepository.save(userAtualizar);
    }

    public void excluir(Long id) {
        User user = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.deleteById(id);
    }
}
