package com.db1.cidadesapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db1.cidadesapi.entities.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

	List<Agencia> findByCidadeId(Long id);
	
}
