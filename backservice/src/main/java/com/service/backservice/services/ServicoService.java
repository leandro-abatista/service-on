package com.service.backservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.backservice.entities.Servico;
import com.service.backservice.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	/**
	 * Método para listar todos os serviços criados
	 * @return
	 */
	public List<Servico> listarTodos(){
		return servicoRepository.findAll();//retorna todos os serviços.
	}
	
	/**
	 * Método para inserir um novo serviço
	 * @param servico
	 * @return
	 */
	public Servico inserir(Servico servico) {
		return servicoRepository.saveAndFlush(servico);
	}
	
	/**
	 * Método para atualizar um serviço já existente
	 * @param servico
	 * @return
	 */
	public Servico alterar(Servico servico) {
		return servicoRepository.saveAndFlush(servico);
	}
}
