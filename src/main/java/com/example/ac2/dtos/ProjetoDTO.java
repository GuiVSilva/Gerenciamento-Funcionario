package com.example.ac2.dtos;

import java.time.LocalDate;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoDTO {
    private int id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFinalizacao;
    private List<FuncionarioDadosDTO> funcionarios;

}
