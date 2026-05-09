package com.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.boot.domain.Funcionario;
import com.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "funcionario/lista";
    }

    @GetMapping("/editar/{id}")
    public String preAlterar(@PathVariable Long id) {
        return "funcionario/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario) {
        service.salvar(funcionario);
        return "redirect:/funcionarios/cadastrar";
    }

    @PostMapping("/editar")
    public String alterar(Funcionario funcionario) {
        service.editar(funcionario);
        return "redirect:/funcionarios/cadastrar";
    }
}