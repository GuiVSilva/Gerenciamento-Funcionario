package com.example.ac2.services;

import com.example.ac2.dtos.SetorDTO;

public interface SetorService {

    void salvarSetor(SetorDTO setorDTO);
    SetorDTO buscarSetorPorId(Integer id);
    void deletarSetor(Integer id);
    void vincularSetorAFuncionario(Integer idFuncionario, Integer idSetor);
    
}
