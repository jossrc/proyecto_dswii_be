package com.earthbook.proyecto_dswii_be.service.impl;

import java.util.List;
import java.util.Optional;

import com.earthbook.proyecto_dswii_be.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.convertidor.convertidorAutor;
import com.earthbook.proyecto_dswii_be.jpa.entity.AutorJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.AutorRepository;
import com.earthbook.proyecto_dswii_be.model.dto.AutorDTO;

@Service("autorService")
public class AutorServiceImpl implements AutorService {

	@Autowired
	@Qualifier("repositorioAutor")
	private AutorRepository repo;

	@Autowired
	@Qualifier("convertidorAutor")
	private convertidorAutor conv;

	@Override
	public List<AutorDTO> listar() {

		List<AutorJPA> lib = repo.findAll();

		return conv.convertirLista(lib);
	}

	@Override
	public AutorDTO autorId(int id) {
		try {
			Optional<AutorJPA> lib = repo.findById(id);
			if (lib.isPresent()) {
				return new AutorDTO(lib.get());
			} else {
				System.out.println("Id ingresado no existe");
			}
			return null;
		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado al buscar el autor");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean insert(AutorDTO autor) {

		try {
			repo.save(new AutorJPA(autor));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(AutorDTO autor) {

		try {
			repo.save(new AutorJPA(autor));
			return true;
		} catch (Exception e) {
			System.out.println("Se encontró un error al actualizar el autor.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {

		try {
			Optional<AutorJPA> lib = repo.findById(id);
			if (lib.isPresent()) {
				repo.delete(lib.get());
			} else {
				System.out.println("Id ingresado no existe");
			}
			return true;
		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado al borrar el autor");
			e.printStackTrace();
			return false;
		}
	}

}
