package com.senior.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.desafio.model.Cliente;
import com.senior.desafio.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente findByIdCliente(Long id) {
		return clienteRepository.findByIdCliente(id);
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}

}
