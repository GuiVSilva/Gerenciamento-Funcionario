package com.example.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ac2.dtos.FuncionarioDTO;
import com.example.ac2.dtos.SetorDTO;
import com.example.ac2.exception.RegraNegocioException;
import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Setor;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.SetorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetorServiceImp implements SetorService {

    private final SetorRepository setorRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public void salvarSetor(SetorDTO setorDTO) {
       Setor setor = new Setor();
       setor.setNome(setorDTO.getNome());
       setorRepository.save(setor);
    }

    @Override
    @Transactional
    public SetorDTO buscarSetorPorId(Integer id) {
        Setor setor = setorRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Setor não encontrado com o ID fornecido"));

        List<FuncionarioDTO> funcionarioDTO = setor.getFuncionarios().stream()
        .map(funcionario -> new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), setor.getNome()))
        .collect(Collectors.toList());

        return new SetorDTO(setor.getId(), setor.getNome(), funcionarioDTO);
    }

    @Override
    @Transactional
    public void deletarSetor(Integer id) {
       setorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void vincularSetorAFuncionario(Integer idFuncionario, Integer idSetor) {
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new RegraNegocioException("Funcionario não encontrado com o ID fornecido"));

        Setor setor = setorRepository.findById(idSetor).orElseThrow(() -> new RegraNegocioException("Setor não encontrado com o ID fornecido"));

        //adiciona o setor ao conjunto de funcionarios
        setor.getFuncionarios().add(funcionario);
        //salva o setor no banco
        setorRepository.save(setor);
    }
    
}
