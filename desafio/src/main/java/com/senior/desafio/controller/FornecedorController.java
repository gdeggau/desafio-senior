package com.senior.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senior.desafio.model.Fornecedor;
import com.senior.desafio.service.FornecedorService;

@Controller
@RequestMapping("/desafio")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@PostMapping("/fornecedores")
	public ResponseEntity<Fornecedor> save(@Valid @RequestBody Fornecedor fornecedor){
		return ResponseEntity.ok().body(fornecedorService.save(fornecedor));
	}
	
	@PutMapping("/fornecedores/{id}")
	public ResponseEntity<Fornecedor> update(@PathVariable Long id, @Valid @RequestBody Fornecedor fornecedorDetalhes){
		Fornecedor fornecedor = fornecedorService.findByIdFornecedor(id);
		if(fornecedor == null)
			return ResponseEntity.notFound().build();
		BeanUtils.copyProperties(fornecedorDetalhes, fornecedor, "idFornecedor");
		Fornecedor attFornecedor = fornecedorService.save(fornecedor);
		return ResponseEntity.ok().body(attFornecedor);
	}
	
	@DeleteMapping("/fornecedores/{id}")
	public ResponseEntity<Fornecedor> delete(@PathVariable Long id) {
		
		Fornecedor fornecedor = fornecedorService.findByIdFornecedor(id);
		
		if(fornecedorService == null)
			return ResponseEntity.notFound().build();
		
		fornecedorService.deleteById(fornecedor.getIdFornecedor());
		
		return ResponseEntity.ok().build();
	}

}
