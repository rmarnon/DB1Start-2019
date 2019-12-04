package com.db1.cidadesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.entities.Agencia;
import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.repositories.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	@Autowired
	private CidadeService cidadeService;
	
	public Agencia criaAgencia(String numero, String numeroBanco, Long cidadeId) {
		Cidade cidade = cidadeService.buscarPorId(cidadeId);
		Agencia agencia = new  Agencia(numero, numeroBanco, cidade);
		return agenciaRepository.save(agencia);
	}
	
	public void limpar() {
		agenciaRepository.deleteAll();
	}
	
	public Agencia buscarPorId(Long id) {
		Optional<Agencia> agencia = agenciaRepository.findById(id);
		return agencia.orElseThrow(() -> new RuntimeException("Agencia nao identificada! id: " 
				+ id + ", Tipo: " + Agencia.class.getName()));
	}
	
	public List<Agencia> buscarTodasAgencias() {
		List<Agencia> agencia = agenciaRepository.findAll();
		return agencia;
	}
	
	public List<Agencia> buscarTodasPeloIdDaCidade(Long cidadeId) {
        return agenciaRepository.findByCidadeId(cidadeId);
    }
	
	public void deletarTodasAgencias() {
    	agenciaRepository.deleteAll();
    }
	
}
