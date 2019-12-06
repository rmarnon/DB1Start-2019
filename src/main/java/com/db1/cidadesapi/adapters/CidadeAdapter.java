package com.db1.cidadesapi.adapters;

import com.db1.cidadesapi.dto.CidadeDTO;
import com.db1.cidadesapi.dto.CidadeFormDTO;
import com.db1.cidadesapi.entities.Cidade;

public class CidadeAdapter {

	public static CidadeDTO transformaEntidadeParaDTO(Cidade cidade) {
		CidadeDTO dto = new CidadeDTO();
		dto.setId(cidade.getId());
		dto.setName(cidade.getNome());
		dto.setEstado(cidade.getUf());
		return dto;
	}
	
    public static Cidade converteDTOParaEntidadeCidade(CidadeFormDTO dto) {
        Cidade cidade = new Cidade();
        cidade.setNome(dto.getNome());
        return cidade;
    }
    
}
