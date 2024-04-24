package com.example.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ac2.dtos.SetorDTO;
import com.example.ac2.models.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer> {
    
    @Query("SELECT s, f FROM Setor s JOIN s.funcionarios f")
    List<SetorDTO> findAllWithFuncionarios();
}
