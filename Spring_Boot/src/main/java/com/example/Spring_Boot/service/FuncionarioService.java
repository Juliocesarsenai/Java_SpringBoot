package com.example.Spring_Boot.service;

import com.example.Spring_Boot.model.Funcionario;
import com.example.Spring_Boot.repository.EnderecoRepository;
import com.example.Spring_Boot.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final EnderecoRepository enderecoRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, EnderecoRepository enderecoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    @Transactional
    public Funcionario salvarFuncionario(Funcionario funcionario) {
        if (funcionario.getEndereco() != null) {
            enderecoRepository.save(funcionario.getEndereco());
        }
        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}