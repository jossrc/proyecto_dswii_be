package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.entity.Libro;
import com.earthbook.proyecto_dswii_be.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{
	@Autowired
	private LibroRepository repository;
	
	@Override
	public List<Libro> listar() {
		return repository.findAll();
	}
	
}
