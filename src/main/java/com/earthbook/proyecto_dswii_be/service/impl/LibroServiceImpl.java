package com.earthbook.proyecto_dswii_be.service.impl;

import java.util.List;
import java.util.Optional;

import com.earthbook.proyecto_dswii_be.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.convertidor.convertidorLibro;
import com.earthbook.proyecto_dswii_be.jpa.entity.LibroJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.LibroRepository;
import com.earthbook.proyecto_dswii_be.model.dto.LibroDTO;

@Service("libroService")
public class LibroServiceImpl implements LibroService {

	@Autowired
	@Qualifier("repositorioLibro")
	private LibroRepository repo;

	@Autowired
	@Qualifier("convertidorLibro")
	private convertidorLibro conv;

	@Override
	public List<LibroDTO> listar() {

		List<LibroJPA> lib = repo.findAll();

		return conv.convertirLista(lib);
	}

	@Override
	public LibroDTO libroId(int id) {
		try {
			Optional<LibroJPA> lib = repo.findById(id);
			if (lib.isPresent()) {
				return new LibroDTO(lib.get());
			} else {
				System.out.println("Id ingresado no existe");
			}
			return null;
		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado al buscar el libro");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean insert(LibroDTO libro) {

		try {
			repo.save(new LibroJPA(libro));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(LibroDTO libro) {

		try {
			repo.save(new LibroJPA(libro));
			return true;
		} catch (Exception e) {
			System.out.println("Se encontro un error al actualizar la categoria.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {

		try {
			Optional<LibroJPA> lib = repo.findById(id);
			if (lib.isPresent()) {
				repo.delete(lib.get());
			} else {
				System.out.println("Id ingresado no existe");
			}
			return true;
		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado al borrar el libro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<LibroDTO> listarPorAutorCategoria(int idAutor, int idCategoria) {

		List<LibroJPA> lib = repo.listarLibrosPorAutorCategoria(idAutor, idCategoria);

		return conv.convertirLista(lib);
	}

}
