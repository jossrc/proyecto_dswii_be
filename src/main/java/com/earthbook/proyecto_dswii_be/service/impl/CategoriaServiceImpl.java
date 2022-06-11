package com.earthbook.proyecto_dswii_be.service.impl;


import com.earthbook.proyecto_dswii_be.convertidor.convertidorCategoria;
import com.earthbook.proyecto_dswii_be.jpa.entity.CategoriaJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.CategoriaRepository;
import com.earthbook.proyecto_dswii_be.model.dto.CategoriaDTO;
import com.earthbook.proyecto_dswii_be.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    @Qualifier("repositorioCategorias")
    private CategoriaRepository repositorio;
    
    @Autowired
    @Qualifier("convertidorCategoria")
    private convertidorCategoria convertidor;

	@Override
	public boolean crear(CategoriaDTO categoria) {
		System.out.println("ini: crear Categoria");
		try {
			repositorio.save(new CategoriaJPA(categoria));
			return true;
		} catch (Exception e) {
			System.out.println("Se encontro un error al crear la categoria.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(CategoriaDTO categoria) {
		System.out.println("ini: actualizar Categoria");
		try {
			repositorio.save(new CategoriaJPA(categoria));
			return true;
		} catch (Exception e) {
			System.out.println("Se encontro un error al actualizar la categoria.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borrar(int id) {
		System.out.println("ini: borrar Categoria");
		try {
			Optional<CategoriaJPA> cate = repositorio.findById(id);
			if(cate.isPresent()) {
				repositorio.delete(cate.get());
			} else {
				System.out.println("No existe el ID.");
			}
			return true;
		} catch (Exception e) {
			System.out.println("Se encontro un error al borrar la categoria.");
			e.printStackTrace();
			return false;
		}
	}

    @Override
    public List<CategoriaDTO> listar() {
        List<CategoriaJPA> cate = repositorio.findAll();
        
        return convertidor.convertirLista(cate);
    }

	@Override
	public CategoriaDTO categoriaPorId(int id) {
		System.out.println("ini: encontrar Categoria por ID");
		try {
			Optional<CategoriaJPA> cate = repositorio.findById(id);
			if(cate.isPresent()) {
				return new CategoriaDTO(cate.get());
			} else {
				System.out.println("No existe el ID.");
			}
			return null;
		} catch (Exception e) {
			System.out.println("Se encontro un error al obtener la categoria.");
			e.printStackTrace();
			return null;
		}
	}

}
