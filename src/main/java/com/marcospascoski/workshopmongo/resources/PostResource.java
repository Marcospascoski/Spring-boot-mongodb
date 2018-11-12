package com.marcospascoski.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcospascoski.workshopmongo.domain.Post;
import com.marcospascoski.workshopmongo.resources.util.URL;
import com.marcospascoski.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/pesquisatitulo",method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value="texto", defaultValue="") String texto ){
		texto = URL.decodeParam(texto);
		List<Post> list = service.findbyTitulo(texto);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/pesquisacompleta",method=RequestMethod.GET)
	public ResponseEntity<List<Post>> pesquisaCompleta(
			@RequestParam(value="texto", defaultValue="") String texto,
			@RequestParam(value="minData", defaultValue="") String minData,
			@RequestParam(value="maxData", defaultValue="") String maxData){
		texto = URL.decodeParam(texto);
		Date min = URL.convertData(minData, new Date(0L));
		Date max = URL.convertData(maxData, new Date());
		List<Post> list = service.pesquisaCompleta(texto, min, max);
		return ResponseEntity.ok().body(list);
	}
}
