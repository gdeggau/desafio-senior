package com.senior.desafio.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.senior.desafio.model.Role;
import com.senior.desafio.model.Usuario;
import com.senior.desafio.repository.RoleRepository;
import com.senior.desafio.repository.UsuarioRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired UsuarioRepository usuarioRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<Usuario> users = usuarioRepository.findAll();
		if(users.isEmpty()) {
			criarUsuarios("Gabriel", "admin", passwordEncoder.encode("12345"), "ROLE_ADMIN");
			criarUsuarios("Bruna", "bruna@gmail.com", passwordEncoder.encode("12345"), "ROLE_ADMIN");
			criarUsuarios("Lucas", "lucas@gmail.com", passwordEncoder.encode("12345"), "ROLE_ADMIN");
		}
	}
	
	public void criarUsuarios(String nome, String email, String senha, String role) {
		
		Role roleObject = new Role();
		roleObject.setNmRole(role);
		
		roleRepository.save(roleObject);
		
		Usuario usuario = new Usuario(nome, email, senha, Arrays.asList(roleObject));
		usuarioRepository.save(usuario);
	}

}
