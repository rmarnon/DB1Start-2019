package com.db1.cidadesapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@JoinColumn(name = "agencia_id", referencedColumnName = "id", nullable = false)
	private Agencia agencia;
	
	@Column(name = "saldo", nullable = false)
	private Double saldo;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "cliente_id", nullable = false)
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
	
	public void saque(double valor) {
		if(valor > saldo) {
			throw new RuntimeException("Saldo insuficiente para o valor de R$" + String.format("%.2f", valor));
		}
		if(valor < 0) {
			throw new RuntimeException("impossivel sacar valores inferior a zero!");
		}
		saldo -= valor;
	}
	
	public void alteraTipo(EstadoConta estado) {
		this.estado = estado;
	}
	
	public void depositar(Double montante) {
		if(montante ==  null) {
			throw new RuntimeException("Valor nao pode ser nulo!");
		}
		if(montante < 0) {
			throw new RuntimeException("Valor insuficiente!");
		}
		saldo += montante;
	}
	
	public void transferencia(double montante, Conta conta) {
		if(montante > saldo) {
			throw new RuntimeException("Saldo insuficiente para tranferencia!");
		}
		if(conta == null) {
			throw new RuntimeException("Conta inexistente");
		}
		saque(montante);
		conta.depositar(montante);
	}

}
