package com.marcospascoski.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcospascoski.workshopmongo.domain.Post;
import com.marcospascoski.workshopmongo.repository.PostRepository;
import com.marcospascoski.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findbyTitulo(String texto){
		//return repo.findByTituloContainingIgnoreCase(texto);
		return repo.pesquisaTitulo(texto);
	}
}
