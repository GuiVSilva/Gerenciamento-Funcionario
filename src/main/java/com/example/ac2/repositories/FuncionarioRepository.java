package com.example.ac2.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ac2.models.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

    @Query("SELECT f FROM Funcionario f LEFT JOIN FETCH f.projetos p WHERE f.id = :funcionarioId")
    Funcionario findDadosFuncionarioById(Long funcionarioId);


}
