package com.example.Spring_Boot.controller;

import com.example.Spring_Boot.exception.RecursoNaoEncontrado;
import com.example.Spring_Boot.model.Funcionario;
import com.example.Spring_Boot.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @PostMapping
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvarFuncionario(funcionario);
    }

    @DeleteMapping
    public void deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
    }

    @GetMapping("/{id}")
    public Funcionario buscarFuncionarioPorId(@PathVariable Long id) {
        return funcionarioService.buscarFuncionarioPorId(id).orElseThrow(() ->
                new RecursoNaoEncontrado("Funcionário não encontrado com id: " + id));
    }
    }



