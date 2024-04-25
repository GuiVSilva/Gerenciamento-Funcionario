package com.example.ac2.services;

import com.example.ac2.dtos.ProjetoDTO;

public interface ProjetoService {

    void salvarProjeto(ProjetoDTO  projetoDTO);
    ProjetoDTO buscarProjetoPorId(int id);
    void vincularProjetoAFuncionario(Integer idFuncionario, Integer idProjeto);
    void deletarProjeto(Integer id);
}
