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

import com.senior.desafio.model.Produto;
import com.senior.desafio.service.ProdutoService;

@Controller
@RequestMapping("/desafio")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto){
		return ResponseEntity.ok().body(produtoService.save(produto));
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @Valid @RequestBody Produto produtoDetalhes){
		Produto produto = produtoService.findByIdProduto(id);
		if(produto == null)
			return ResponseEntity.notFound().build();
		BeanUtils.copyProperties(produtoDetalhes, produto, "idProduto");
		Produto attProduto = produtoService.save(produto);
		return ResponseEntity.ok().body(attProduto);
	}
	
	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<Produto> delete(@PathVariable Long id) {
		
		Produto produto = produtoService.findByIdProduto(id);
		
		if(produtoService == null)
			return ResponseEntity.notFound().build();
		
		produtoService.deleteById(produto.getIdProduto());
		
		return ResponseEntity.ok().build();
	}

}
