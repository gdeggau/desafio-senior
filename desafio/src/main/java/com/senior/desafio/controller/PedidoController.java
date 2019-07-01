package com.senior.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senior.desafio.model.Pedido;
import com.senior.desafio.service.PedidoService;

@Controller
@RequestMapping("/desafio")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> save(@Valid @RequestBody Pedido pedido){
		return ResponseEntity.ok().body(pedidoService.save(pedido));
	}
	
}
