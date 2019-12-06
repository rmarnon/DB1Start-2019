package com.db1.cidadesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.entities.Conta;
import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.enums.CidadeTipo;
import com.db1.cidadesapi.enums.EstadoConta;
import com.db1.cidadesapi.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoService estadoService;

	public Cidade criarCidade(String nome, Long estadoId) {
		Estado estado = estadoService.buscarPorId(estadoId);
		Cidade cidade = new Cidade(nome, estado);
		return cidadeRepository.save(cidade);
	}

	public void deletarTodasAsCidades() {
		cidadeRepository.deleteAll();
	}

	public Cidade buscarPorNome(String nome) {
		return cidadeRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Cidade nao encontrada"));
	}

	public Cidade buscarPorId(Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cidade.orElseThrow(
				() -> new RuntimeException("Cidade nao encontrada! id: " + id + ", Tipo: " + Cidade.class.getName()));
	}

	public Cidade atualizarNomeDaCidade(Long cidadeId, String novoNomeDaCidade) {
		Cidade cidade = buscarPorId(cidadeId);
		cidade.setNome(novoNomeDaCidade);
		return cidadeRepository.save(cidade);
	}

	public List<Cidade> buscarTodosPeloIdDaCidade(Long cidadeId) {
		return cidadeRepository.findEstadoById(cidadeId);
	}

	public List<Cidade> buscarTodasAsCidades() {
		return cidadeRepository.findAll();
	}
	
	public void alterarTipoCidade(Long id, String tipo) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		cidade.ifPresent(cid -> {
			cid.alteraTipo(CidadeTipo.valueOf(tipo));
			cidadeRepository.save(cid);
		});
	}
	
	public void deletarPorId(Long id) {
		cidadeRepository.deleteById(id);
	}

}
