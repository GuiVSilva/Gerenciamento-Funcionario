package com.example.ac2.services;

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
public class ProjetoServiceImp implements ProjetoService {
    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public void salvarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto();
        projeto.setDescricao(projetoDTO.getDescricao());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFinalizacao(projetoDTO.getDataFinalizacao());
        projetoRepository.save(projeto);
    }

    @Override
    @Transactional
    public ProjetoDTO buscarProjetoPorId(Integer id) {
       Projeto projeto = projetoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Projeto não encontrado com o ID fornecido"));

       return new ProjetoDTO(projeto.getId(), projeto.getDescricao(), projeto.getDataInicio(), projeto.getDataFinalizacao(), projeto.getFuncionarios().stream()
       .map((Funcionario funcionario) -> new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getSetor().getNome())).collect(Collectors.toList()));
    }

    @Override
    @Transactional
    public void vincularProjetoAFuncionario(Integer idFuncionario, Integer idProjeto) {
        Projeto projeto = projetoRepository.findById(idProjeto).orElseThrow(() -> new RegraNegocioException("Projeto não encontrado com o ID fornecido"));

        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new RegraNegocioException("Funcionario não encontrado com o ID fornecido"));

        //adiciona funcionario ao conjunto de projetos
        projeto.getFuncionarios().add(funcionario);
        //salva projeto no banco
        projetoRepository.save(projeto);
    }

    @Override
    @Transactional
    public void deletarProjeto(Integer id) {
        projetoRepository.deleteById(id);
    }
    
}
