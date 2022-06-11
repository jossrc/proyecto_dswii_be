package com.earthbook.proyecto_dswii_be.service.impl;

import java.util.List;

import com.earthbook.proyecto_dswii_be.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.jpa.entity.EditorialJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.EditorialRepository;

@Service
public class EditorialServiceImpl implements EditorialService {
	@Autowired
	private EditorialRepository repository;
	
	@Override
	public List<EditorialJPA> listar() {
		return repository.findAll();
	}

}
