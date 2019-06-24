package com.senior.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.desafio.model.Fornecedor;
import com.senior.desafio.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor save(Fornecedor fornecedor){
		return fornecedorRepository.save(fornecedor);
	}
	
	public void deleteById(Long id) {
		fornecedorRepository.deleteById(id);
	}

	public Fornecedor findByIdFornecedor(Long id) {
		return fornecedorRepository.findByIdFornecedor(id);
	}


}
