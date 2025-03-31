package com.example.Spring_Boot.repository;

import com.example.Spring_Boot.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
