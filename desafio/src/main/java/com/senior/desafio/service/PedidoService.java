package com.senior.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.desafio.model.Cliente;
import com.senior.desafio.model.Pedido;
import com.senior.desafio.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired ProdutoService produtoService;
	
	public Pedido save(Pedido pedido){
		Cliente cliente = clienteService.findByIdCliente(pedido.getIdCliente().getIdCliente());
		pedido.setIdCliente(cliente);
		
		return pedidoRepository.save(pedido);
	}

	
	/*public void deleteById(Long id) {
		pedidoRepository.deleteById(id);
	}*/

}
