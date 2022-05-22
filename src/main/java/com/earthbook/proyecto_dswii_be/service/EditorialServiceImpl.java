package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.entity.Editorial;
import com.earthbook.proyecto_dswii_be.repository.EditorialRepository;

@Service
public class EditorialServiceImpl implements EditorialService{
	@Autowired
	private EditorialRepository repository;
	
	@Override
	public List<Editorial> listar() {
		return repository.findAll();
	}

}
