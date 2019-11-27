package com.db1.cidadesapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db1.cidadesapi.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Optional<Estado> findByNome(String nome);
	
}
