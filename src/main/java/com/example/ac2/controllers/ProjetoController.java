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

import com.example.ac2.dtos.ProjetoDTO;
import com.example.ac2.services.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public void adicionarProjeto(@RequestBody ProjetoDTO projetoDTO){
        projetoService.salvarProjeto(projetoDTO);
    }

    @GetMapping("/{id}")
    public ProjetoDTO buscarProjetoPorId(@PathVariable int id){
        return  projetoService.buscarProjetoPorId(id);
    }

    @PutMapping("/{id}/funcionario/{idFuncionario}")
    public void vincularProjetoAFuncionario(@PathVariable Integer idProjeto, Integer idFuncionario){
        projetoService.vincularProjetoAFuncionario(idProjeto, idFuncionario);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Integer id){
        projetoService.deletarProjeto(id);
    }
}
