package com.service.backservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.backservice.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

	@Query("select s from Servico s where s.valorRecebido is null or s.valorRecebido = 0 ")
	List<Servico> buscarServicosPagamentoPendentes();
	
	@Query("select s from Servico s where s.status = 'cancelado'")
	List<Servico> buscarServicosCancelados();
}
