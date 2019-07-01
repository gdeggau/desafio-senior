package com.senior.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senior.desafio.model.Usuario;
import com.senior.desafio.service.UsuarioService;

@Controller
@RequestMapping("/desafio")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.ok().body(usuarioService.findAll());
	}

}
