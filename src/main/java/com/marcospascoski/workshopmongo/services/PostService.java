package com.marcospascoski.workshopmongo.services;

import java.util.Date;
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
	
	public List<Post> pesquisaCompleta(String texto, Date minData, Date maxData){
		maxData = new Date(maxData.getTime() + 24 * 60 * 60 * 1000);
		return repo.pesquisaCompleta(texto, minData, maxData);
	}
}
