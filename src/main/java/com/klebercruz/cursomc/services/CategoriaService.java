package com.klebercruz.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klebercruz.cursomc.domain.Categoria;
import com.klebercruz.cursomc.repositories.CategoriaRepository;
import com.klebercruz.cursomc.services.exceptions.ObjectNotFoundException;




@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id)     {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
					+ ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
}
