package com.marcospascoski.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcospascoski.workshopmongo.domain.Post;
import com.marcospascoski.workshopmongo.domain.Usuario;
import com.marcospascoski.workshopmongo.dto.AutorDTO;
import com.marcospascoski.workshopmongo.repository.PostRepository;
import com.marcospascoski.workshopmongo.repository.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepository.deleteAll();
		postRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario paulo = new Usuario(null, "Paulo Green", "paulo@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(maria, paulo, bob));
		
		Post post1 = new Post(null, sdf.parse("11/11/2018"), "Partiu Viagem", "Vou Viajar para Goiania. Abraços!", new AutorDTO(maria));
		Post post2 = new Post(null, sdf.parse("10/11/2018"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
