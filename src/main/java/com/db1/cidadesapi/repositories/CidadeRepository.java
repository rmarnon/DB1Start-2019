package com.db1.cidadesapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db1.cidadesapi.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	Optional<Cidade> findByNome(String nome);
	List<Cidade> findEstadoById(Long id);
	
}
