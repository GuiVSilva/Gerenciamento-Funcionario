package com.example.ac2.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ac2.dtos.ProjetoDTO;
import com.example.ac2.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    
 
    @Query("SELECT p, f FROM Projeto p JOIN p.funcionarios f WHERE p.id = :projetoId")
    ProjetoDTO findDadosProjetoById(Long projetoId);

    @Query("SELECT p FROM Projeto p WHERE p.dataInicio >= :dataInicio AND p.dataFinalizacao <= :dataFinalizacao")
    List<Projeto> findProjetosByDataInicioAndDataFim(LocalDate dataInicio, LocalDate dataFinalizacao);
 
}
