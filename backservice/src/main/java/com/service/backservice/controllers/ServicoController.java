package com.service.backservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.backservice.entities.Servico;
import com.service.backservice.services.ServicoService;

import jakarta.websocket.server.PathParam;

/**
 * Classe de controle, onde realiza a comunicação entre a classe intermediária de  serviço
 * que por sua vez se comunica com a classe responsável por acessar o banco de dados.
 * @author LYANN
 *
 */
@RestController
@RequestMapping("/api/backservice")
public class ServicoController {

	@Autowired//injeção de dependência
	private ServicoService servicoService;
	
	/**
	 * Método listar todos os serviços
	 * @return
	 */
	@GetMapping("/")
	public List<Servico> buscarTodos(){
		return servicoService.listarTodos();
	}
	
	/**
	 * Método para buscar todos os serviços com pagamento pendente ou com valor igual a 0
	 * @return
	 */
	@GetMapping("/pagamentosPendentes")
	@CrossOrigin("http://localhost:5173")
	public List<Servico> buscarServicosPagamentosPendente() {
		return servicoService.buscarServicosPagamentosPendente();
	}
	
	/**
	 * Método para todos os serviços cancelados
	 * @return
	 */
	@GetMapping("/servicosCancelados")
	@CrossOrigin("http://localhost:5173")
	public List<Servico> buscarServicosCancelados() {
		return servicoService.buscarServicosCancelados();
	}
	
	@PostMapping("/cadastrar")
	@CrossOrigin("http://localhost:5173")
	public Servico inserir(@RequestBody Servico s) {
		return servicoService.inserir(s);
	}
	
	@PutMapping("/atualizar")
	@CrossOrigin("http://localhost:5173")
	public Servico alterar(@RequestBody Servico s) {
		return servicoService.alterar(s);
	}
	
	@PostMapping("/cancelar/{id}")
	@CrossOrigin("http://localhost:5173")
	public ResponseEntity<Void> cancelar(@PathVariable("id") Long id) {
		servicoService.cancelarServico(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/remover/{id}")
	@CrossOrigin("http://localhost:5173")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		servicoService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
