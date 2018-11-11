package com.marcospascoski.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcospascoski.workshopmongo.domain.Usuario;
import com.marcospascoski.workshopmongo.dto.UsuarioDTO;
import com.marcospascoski.workshopmongo.repository.UsuarioRepository;
import com.marcospascoski.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Usuario insert(Usuario obj) {
		return repo.insert(obj);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
}
