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

import com.db1.cidadesapi.adapters.CidadeAdapter;
import com.db1.cidadesapi.dto.CidadeDTO;
import com.db1.cidadesapi.dto.CidadeFormDTO;
import com.db1.cidadesapi.entities.Cidade;
import com.db1.cidadesapi.entities.Estado;
import com.db1.cidadesapi.services.CidadeService;

@RestController
public class CidadeControler {

	@Autowired
	public CidadeService cidadeService;

	@GetMapping("/cidades")
	public List<CidadeDTO> buscaTodasAsCidades() {
		List<Cidade> cidades = cidadeService.buscarTodasAsCidades();
		return cidades.stream().map(CidadeAdapter::transformaEntidadeParaDTO).collect(Collectors.toList());
	}

	@PostMapping("/cidades")
	public CidadeDTO cadastrarNovaCidade(@RequestBody CidadeFormDTO cidadeFormDTO, Estado estadoId) {
		Cidade cidade = cidadeService.criarCidade(cidadeFormDTO.getNome(), estadoId.getId());
		return CidadeAdapter.transformaEntidadeParaDTO(cidade);
	}

	@PutMapping("/cidades/{cidadeId}")
	public CidadeDTO alterarCidade(@PathVariable Long cidadeId, @RequestBody String formDTO) {
		Cidade cidadeAlterada = cidadeService.atualizarNomeDaCidade(cidadeId, formDTO);
		return CidadeAdapter.transformaEntidadeParaDTO(cidadeAlterada);
	}

	@DeleteMapping("/cidades/{cidadeId}")
	public void deletarCidade(@PathVariable Long cidadeId) {
		cidadeService.deletarPorId(cidadeId);
	}

}
