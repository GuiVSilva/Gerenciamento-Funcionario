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

import com.example.ac2.dtos.SetorDTO;
import com.example.ac2.services.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {
    @Autowired
    private SetorService setorService;

    @PostMapping
    public void  salvarSetor(@RequestBody SetorDTO setorDTO){
        setorService.salvarSetor(setorDTO);
    }

    @GetMapping("/{id}")
    public SetorDTO buscarSetorPorId(@PathVariable Integer id){
        return setorService.buscarSetorPorId(id);
    }

    @PutMapping("/{id}/funcionario/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idSetor, Integer idFuncionario){
        setorService.vincularSetorAFuncionario(idFuncionario, idSetor);
    }

    @DeleteMapping("/{id}")
    public void deletarSetor(@PathVariable Integer id){
        setorService.deletarSetor(id);
    }
}
