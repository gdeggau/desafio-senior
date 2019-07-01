package com.senior.desafio.controller;


import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senior.desafio.model.Cliente;
import com.senior.desafio.service.ClienteService;

@RestController
@RequestMapping("/desafio")
@CrossOrigin(origins = {"https://localhost:4200", "http://localhost:8080"})
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente){
		return ResponseEntity.ok().body(clienteService.save(cliente));
	}
	
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody Cliente clienteDetalhes){
		Cliente cliente = clienteService.findByIdCliente(id);
		if(cliente == null)
			return ResponseEntity.notFound().build();
		BeanUtils.copyProperties(clienteDetalhes, cliente, "idCliente");
		Cliente attCliente = clienteService.save(cliente);
		return ResponseEntity.ok().body(attCliente);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Long id) {
		
		Cliente cliente = clienteService.findByIdCliente(id);
		
		if(clienteService == null)
			return ResponseEntity.notFound().build();
		
		clienteService.deleteById(cliente.getIdCliente());
		
		return ResponseEntity.ok().build();
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/clientes")
	public ResponseEntity<Page<Cliente>> findAll(@RequestParam("page") int page, @RequestParam("size") int size){
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok().body(clienteService.findAll(pageable));
	}

}
