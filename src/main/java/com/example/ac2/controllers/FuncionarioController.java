package com.example.ac2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.FuncionarioDTO;
import com.example.ac2.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public void salvarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO){
        funcionarioService.salvarFuncionario(funcionarioDTO);
    }

    @GetMapping("/{id}")
    public FuncionarioDTO buscarFuncionario(@PathVariable Integer id){
        return funcionarioService.buscarFuncionarioPorId(id);
    }

    @PutMapping("/{id}/projetos/{idProjeto}")
    public void vincularProjeto(@PathVariable Integer idFuncionario, @PathVariable Integer idProjeto){
        funcionarioService.vincularProjetoAFuncionario(idProjeto, idFuncionario);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Integer id){
        funcionarioService.deletarFuncionario(id);
    }
}
