package com.senior.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senior.desafio.model.Cliente;
import com.senior.desafio.service.ClienteService;

@RestController
@RequestMapping("/desafio")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente){
		return ResponseEntity.ok().body(clienteService.save(cliente));
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody Cliente clienteDetalhes){
		Cliente cliente = clienteService.findByIdCliente(id);
		if(cliente == null)
			return ResponseEntity.notFound().build();
		BeanUtils.copyProperties(clienteDetalhes, cliente, "idCliente");
		Cliente attCliente = clienteService.save(cliente);
		return ResponseEntity.ok().body(attCliente);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Long id) {
		
		Cliente cliente = clienteService.findByIdCliente(id);
		
		if(clienteService == null)
			return ResponseEntity.notFound().build();
		
		clienteService.deleteById(cliente.getIdCliente());
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> findAll(){
		return ResponseEntity.ok().body(clienteService.findAll());
	}

}
