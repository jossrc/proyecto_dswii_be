package com.earthbook.proyecto_dswii_be.service.impl;

import java.util.List;
import java.util.Optional;

import com.earthbook.proyecto_dswii_be.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.convertidor.convertidorEditorial;
import com.earthbook.proyecto_dswii_be.jpa.entity.EditorialJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.EditorialRepository;
import com.earthbook.proyecto_dswii_be.model.dto.EditorialDTO;

@Service("editorialService")
public class EditorialServiceImpl implements EditorialService {

	@Autowired
    @Qualifier("repositorioEditoriales")
	private EditorialRepository repository;

	@Autowired
	@Qualifier("convertidorEditorial")
	private convertidorEditorial convertidor;
	
	@Override
	public boolean crear(EditorialDTO editorial) {
		System.out.println("ini: crear editorial");
		try {
			repository.save(new EditorialJPA(editorial));
			return true;
		} catch (Exception e) {
			System.out.println("Se encontro un error al crear la editorial.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(EditorialDTO editorial) {
		System.out.println("ini: actualizar editorial");
		try {
			repository.save(new EditorialJPA(editorial));
			return true;
		} catch (Exception e) {
			System.out.println("Se encontro un error al actualizar la editorial.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borrar(int id) {
		System.out.println("ini: borrar editorial");
		try {
			Optional<EditorialJPA> edi = repository.findById(id);
			if(edi.isPresent()) {
				repository.delete(edi.get());
			} else {
				System.out.println("No existe el ID.");
			}
			return true;
		} catch (Exception e) {
			System.out.println("Se encontro un error al borrar la editorial.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public EditorialDTO editorialPorId(int id) {
		System.out.println("ini: encontrar editorial por ID");
		try {
			Optional<EditorialJPA> edi = repository.findById(id);
			if(edi.isPresent()) {
				return new EditorialDTO(edi.get());
			} else {
				System.out.println("No existe el ID.");
			}
			return null;
		} catch (Exception e) {
			System.out.println("Se encontro un error al obtener la editorial.");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EditorialDTO> listar() {
		List<EditorialJPA> edi = repository.findAll();
        
        return convertidor.convertirLista(edi);
	}

}
