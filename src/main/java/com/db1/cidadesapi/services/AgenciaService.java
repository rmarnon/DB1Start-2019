package com.db1.cidadesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidadesapi.repositories.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository repo;
	
}
