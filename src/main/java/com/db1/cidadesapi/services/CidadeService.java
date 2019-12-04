package com.db1.cidadesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.entities.Estado;
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
		return cidadeRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Cidade nao encontrado"));
	}

	public Cidade buscarPorId(Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cidade.orElseThrow(
				() -> new RuntimeException("Cidade nao encontrada! id: " + id + ", Tipo: " + Cidade.class.getName()));
	}

	public Cidade atualizarNomeDaCidade(Long cidadeId, String novoNome) {
		Cidade cidade = buscarPorId(cidadeId);
		cidade.setNome(novoNome);
		return cidadeRepository.save(cidade);
	}

	public List<Cidade> buscarTodosPeloIdDoEstado(Long estadoId) {
		return cidadeRepository.findEstadoById(estadoId);
	}

	public List<Cidade> buscarTodasAsCidades() {
		return cidadeRepository.findAll();
	}

	public void deletarPorId(Long id) {
		cidadeRepository.deleteById(id);
	}

}
