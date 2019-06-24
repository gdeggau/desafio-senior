package com.senior.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.desafio.model.Produto;
import com.senior.desafio.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto){
		return produtoRepository.save(produto);
	}
	
	public void deleteById(Long id) {
		produtoRepository.deleteById(id);
	}

	public Produto findByIdProduto(Long id) {
		return produtoRepository.findByIdProduto(id);
	}

}
