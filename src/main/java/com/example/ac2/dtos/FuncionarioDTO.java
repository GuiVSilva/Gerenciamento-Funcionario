package com.example.ac2.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioDTO {
    private Integer id;
    private String nome;
    private String setorNome;
    private List<ProjetoDTO> projetos;
}
