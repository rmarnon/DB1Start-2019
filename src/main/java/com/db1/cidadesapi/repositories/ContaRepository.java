package com.db1.cidadesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db1.cidadesapi.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
