package com.example.ac2;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.models.Setor;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.ProjetoRepository;
import com.example.ac2.repositories.SetorRepository;
import com.example.ac2.services.FuncionarioService;
import com.example.ac2.services.ProjetoService;
import com.example.ac2.services.SetorService;

@SpringBootApplication
public class Ac2Application {

	@Bean
	public CommandLineRunner init(@Autowired SetorRepository setorRepository, @Autowired FuncionarioRepository funcionarioRepository, @Autowired ProjetoRepository projetoRepository, @Autowired SetorService setorService, @Autowired FuncionarioService funcionarioService, @Autowired ProjetoService projetoService){
		return args -> {

			//Adicionando Setor
			Setor setor = new Setor();
			setor.setNome("TI");
			setorRepository.save(setor);
			

			//Adicionando Funcionario
			Funcionario funcionario = new Funcionario();
			funcionario.setNome("Guilherme ");
			funcionario.setSetor(setor);
			funcionarioRepository.save(funcionario);


			

			
			//Adicionando Projeto
			Projeto projeto = new Projeto();
			projeto.setDescricao("Desenvolvimento de Aplicativo de Gerenciamento de Tarefas");
			LocalDate dataInicio = LocalDate.of(2024, 4, 19);
			projeto.setDataInicio(dataInicio);
			LocalDate dataFim = LocalDate.of(2024, 6, 30); 
			projeto.setDataFinalizacao(dataFim);
			projeto.getFuncionarios().add(funcionario);
			projetoRepository.save(projeto);
			

			//Vincular projeto ao funcionario
			//projetoService.vincularProjetoAFuncionario(funcionario.getId(), projeto.getId());

		
		//	funcionarioRepository.save(funcionario);
		//	projetoRepository.save(projeto);

			System.out.println("Setor: " + setor);
			System.out.println("Funcionario: " + funcionario);
			System.out.println("Projeto: " + projeto);

			System.out.println(projetoService.buscarProjetoPorId(1));

		};
	}














	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}

}
