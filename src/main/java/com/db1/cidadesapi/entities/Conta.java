package com.db1.cidadesapi.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.db1.cidadesapi.enums.EstadoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "agencia_id", referencedColumnName = "id")
	private Agencia agencia;
	private Double saldo;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "cliente_id")
	@MapsId
	private Cliente cliente;
	
	@Enumerated(EnumType.STRING)
	private EstadoConta estado;
	
	public Conta() {
	}

	public Conta(Agencia agencia, double saldo, Cliente cliente, EstadoConta estado) {
		this.agencia = agencia;
		this.saldo = saldo;
		this.cliente = cliente;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public EstadoConta getEstado() {
		return estado;
	}


}
