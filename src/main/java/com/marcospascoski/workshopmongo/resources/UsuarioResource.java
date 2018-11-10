package com.marcospascoski.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcospascoski.workshopmongo.domain.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		Usuario maria = new Usuario("1","Maria peres", "maria@gmail.com");
		Usuario paulo = new Usuario("1","Paulo texas", "paulo@gmail.com");
		Usuario mario = new Usuario("1","Mario pask", "mario@gmail.com");
		List<Usuario>list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, paulo, mario));
		return ResponseEntity.ok().body(list);
	}
}
