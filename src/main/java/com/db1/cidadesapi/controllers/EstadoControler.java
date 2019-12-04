package com.db1.cidadesapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		List<EstadoDTO> lista = new ArrayList<>();
		
		estados.forEach(estado ->  {
			EstadoDTO transformado = EstadoAdapter.transformaEntidadeParaDTO(estado);
			lista.add(transformado);
		});
		return lista;
	}
	
	@PostMapping("/estado")
	public void cadastrarNovoEstado(@RequestBody EstadoFormDTO form) {
		estadoService.criarEstado(form.getNome());
	}
	
}
