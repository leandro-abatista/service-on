package com.service.backservice.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;



@Entity
@Table(name = "servico")
@Data
public class Servico implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio = new Date();//já inicio a data
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTermino;
	
	private String descricao;
	
	private Double valor;
	
	private Double valorRecebido;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPagamento;
	
	private String status;//pendente, realizado ou cancelado
	
}
