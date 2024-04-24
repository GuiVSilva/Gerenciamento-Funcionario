package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.FuncionarioDTO;

public interface FuncionarioService {

    List<FuncionarioDTO> buscarTodosFuncionarios();
    FuncionarioDTO buscarFuncionarioPorId(int id);
    void salvarFuncionario(FuncionarioDTO funcionarioDTO);
    void atualizarFuncionario(Integer id, FuncionarioDTO  funcionarioDTO);
    void deletarFuncionario(int id);
    void vincularProjetoAFuncionario(Integer idProjeto, Integer idFuncionario);
    
}
