package com.service.backservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.backservice.entities.Servico;
import com.service.backservice.services.ServicoService;

/**
 * Classe de controle, onde realiza a comunicação entre a classe intermediária de  serviço
 * que por sua vez se comunica com a classe responsável por acessar o banco de dados.
 * @author LYANN
 *
 */
@RestController
@RequestMapping("/api/servico")
public class ServicoController {

	@Autowired//injeção de dependência
	private ServicoService servicoService;
	
	public List<Servico> buscarTodos(){
		return servicoService.listarTodos();
	}
}
