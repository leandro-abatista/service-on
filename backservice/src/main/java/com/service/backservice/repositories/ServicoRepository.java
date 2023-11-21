package com.service.backservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.backservice.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
