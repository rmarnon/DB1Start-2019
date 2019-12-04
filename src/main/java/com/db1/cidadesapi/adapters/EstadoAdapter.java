package com.db1.cidadesapi.adapters;

import com.db1.cidadesapi.dto.EstadoDTO;
import com.db1.cidadesapi.dto.EstadoFormDTO;
import com.db1.cidadesapi.entities.Estado;

public class EstadoAdapter {

	public static EstadoDTO transformaEntidadeParaDTO(Estado estado) {
		EstadoDTO dto = new EstadoDTO();
		dto.setId(estado.getId());
		dto.setName(estado.getNome());
		return dto;
	}
	
    public static Estado converteDTOParaEntidadeEstado(EstadoFormDTO dto) {
        Estado estado = new Estado();
        estado.setNome(dto.getNome());
        return estado;
    }
    
}
