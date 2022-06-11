package com.earthbook.proyecto_dswii_be.service.impl;

import java.util.List;

import com.earthbook.proyecto_dswii_be.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.jpa.entity.LibroJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {
	@Autowired
	private LibroRepository repository;
	
	@Override
	public List<LibroJPA> listar() {
		return repository.findAll();
	}
	
}
