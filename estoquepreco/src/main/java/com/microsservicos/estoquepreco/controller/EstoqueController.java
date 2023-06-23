package com.microsservicos.estoquepreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservicos.estoquepreco.constantes.RabbitMQConstantes;
import com.microsservicos.estoquepreco.dto.EstoqueDTO;
import com.microsservicos.estoquepreco.service.RabbitMQService;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitMQService service;
	
	@PutMapping
	private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDto) {
		System.out.println(estoqueDto.codigoProduto);
		
		this.service.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDto);
		return new ResponseEntity(HttpStatus.OK);
	}
}
