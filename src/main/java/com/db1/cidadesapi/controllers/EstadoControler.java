package com.db1.cidadesapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db1.cidadesapi.adapters.EstadoAdapter;
import com.db1.cidadesapi.dto.EstadoDTO;
import com.db1.cidadesapi.dto.EstadoFormDTO;
import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.services.EstadoService;

@RestController
public class EstadoControler {

	@Autowired
	public EstadoService estadoService;

	@GetMapping("/estados")
	public List<EstadoDTO> buscaTodosEstados() {
		List<Estado> estados = estadoService.buscarTodos();
		return estados.stream().map(EstadoAdapter::transformaEntidadeParaDTO).collect(Collectors.toList());
	}

	@PostMapping("/estados")
	public EstadoDTO cadastrarNovoEstado(@RequestBody EstadoFormDTO estadoFormDTO) {
		Estado estado = estadoService.criarEstado(estadoFormDTO.getNome());
		return EstadoAdapter.transformaEntidadeParaDTO(estado);
	}

	@PutMapping("/estados/{estadoId}")
	public EstadoDTO alterarEstado(@PathVariable Long estadoId, @RequestBody String formDTO) {
		Estado estadoAlterado = estadoService.atualizarEstado(estadoId, formDTO);
		return EstadoAdapter.transformaEntidadeParaDTO(estadoAlterado);
	}

	@DeleteMapping("/estados/{estadoId}")
	public void deletarEstado(@PathVariable Long estadoId) {
		estadoService.deletarPorId(estadoId);
	}

}
