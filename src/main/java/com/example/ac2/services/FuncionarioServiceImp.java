package com.example.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ac2.dtos.FuncionarioDTO;
import com.example.ac2.dtos.ProjetoDTO;
import com.example.ac2.exception.RegraNegocioException;
import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.ProjetoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImp implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final ProjetoRepository projetoRepository;


    @Override
    @Transactional
    public List<FuncionarioDTO> buscarTodosFuncionarios() {
        return funcionarioRepository.findAll().stream()
        .map(funcionario -> new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getSetor().getNome(),null))
        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FuncionarioDTO buscarFuncionarioPorId(Long id) {

        Funcionario funcionario = funcionarioRepository.findDadosFuncionarioById(id);

        
        FuncionarioDTO dto = FuncionarioDTO.builder()
        .id(funcionario.getId())
        .nome(funcionario.getNome())
        .setorNome(funcionario.getSetor().getNome())
        .projetos(funcionario.getProjetos().stream()
            .map(projeto -> {
                return ProjetoDTO.builder()
                    .id(projeto.getId())
                    .descricao(projeto.getDescricao())
                    .dataInicio(projeto.getDataInicio())
                    .dataFinalizacao(projeto.getDataFinalizacao())
                    .build();
            })
            .collect(Collectors.toList()))
        .build();

        return dto;
    
        
      /*   Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Funcionario não encontrado com o ID fornecido"));
        return new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getSetor().getNome());*/
    }

    @Override
    @Transactional
    public void salvarFuncionario(FuncionarioDTO funcionarioDTO) {
       Funcionario funcionario = new Funcionario();
       funcionario.setNome(funcionarioDTO.getNome());
       funcionarioRepository.save(funcionario);
    }

    @Override
    @Transactional
    public void atualizarFuncionario(Integer id, FuncionarioDTO funcionarioDtO) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Funcionario não encontrado"));
        funcionario.setNome(funcionarioDtO.getNome());

        funcionarioRepository.save(funcionario);
    }

    @Override
    @Transactional
    public void deletarFuncionario(int id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void vincularProjetoAFuncionario(Integer idProjeto, Integer idFuncionario) {
       Projeto projeto = projetoRepository.findById(idProjeto).orElseThrow(() -> new RegraNegocioException("Projeto não encontrado com o ID fornecido"));

       Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new RegraNegocioException("Funcionario não encontrado com o ID fornecido"));

       //adiciona o funcionario ao conjunto de projetos
       projeto.getFuncionarios().add(funcionario);
       //salva o projeto no banco 
       projetoRepository.save(projeto);

    }
    
}
