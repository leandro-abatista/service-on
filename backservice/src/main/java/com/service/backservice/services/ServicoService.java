package com.service.backservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.backservice.entities.Servico;
import com.service.backservice.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired // injeção de dependência
	private ServicoRepository servicoRepository;

	/**
	 * Método para buscar todos os serviços com pagamento pendente ou com valor
	 * igual a 0
	 * 
	 * @return
	 */
	public List<Servico> buscarServicosPagamentosPendente() {
		return servicoRepository.buscarServicosPagamentoPendentes();
	}

	/**
	 * Método para todos os serviços cancelados
	 * 
	 * @return
	 */
	public List<Servico> buscarServicosCancelados() {
		return servicoRepository.buscarServicosCancelados();
	}

	/**
	 * Método para listar todos os serviços criados
	 * 
	 * @return
	 */
	public List<Servico> listarTodos() {
		return servicoRepository.findAll();// retorna todos os serviços.
	}

	/**
	 * Método para inserir um novo serviço
	 * 
	 * @param servico
	 * @return
	 */
	public Servico inserir(Servico s) {

		// if(servico)
		if (s.getValor() == null || s.getValor() == 0 || s.getDataPagamento() == null) {
			s.setStatus("pendente");
		} else {
			s.setStatus("realizado");
		}
		return servicoRepository.saveAndFlush(s);
	}

	/**
	 * Método para atualizar um serviço já existente
	 * 
	 * @param servico
	 * @return
	 */
	public Servico alterar(Servico s) {
		if (s.getValor() != null && s.getValor() != 0 && s.getDataPagamento() != null) {
			s.setStatus("realizado");
		} else {
			s.setStatus("pendente");
		}
		return servicoRepository.saveAndFlush(s);
	}
	
	public void cancelarServico(Long id) {
		Servico s = servicoRepository.findById(id).get();
		s.setStatus("cancelado");
		servicoRepository.save(s);
	}

	/**
	 * Método para excluir um serviço
	 * 
	 * @param id
	 */
	public void excluir(Long id) {
		Servico s = servicoRepository.findById(id).get();
		servicoRepository.delete(s);
	}
}
