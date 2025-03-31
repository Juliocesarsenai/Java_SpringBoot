package com.example.Spring_Boot_Aula.repository;

import com.example.Spring_Boot_Aula.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User,Long> {
}
