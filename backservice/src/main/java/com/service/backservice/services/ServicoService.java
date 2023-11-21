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
	
	public List<Servico> listarTodos(){
		return servicoRepository.findAll();//retorna todos os serviços.
	}
}
