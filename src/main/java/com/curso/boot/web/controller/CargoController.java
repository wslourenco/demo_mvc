package com.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.boot.domain.Cargo;
import com.curso.boot.service.CargoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService service;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar() {
        return "cargo/lista";
    }

    @GetMapping("/editar/{id}")
    public String preAlterar(@PathVariable Long id) {
        return "cargo/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Cargo cargo) {
        service.salvar(cargo);
        return "redirect:/cargos/cadastrar";
    }

    @PostMapping("/editar")
    public String alterar(Cargo cargo) {
        service.editar(cargo);
        return "redirect:/cargos/cadastrar";
    }
}