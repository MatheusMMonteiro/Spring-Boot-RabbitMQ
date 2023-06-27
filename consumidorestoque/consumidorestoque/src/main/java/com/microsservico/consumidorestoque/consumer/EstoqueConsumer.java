package com.microsservico.consumidorestoque.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservicos.estoquepreco.constantes.RabbitMQConstantes;
import com.microsservicos.estoquepreco.dto.EstoqueDTO;

@Component
public class EstoqueConsumer {
	
	private final ObjectMapper objectMapper;

	public EstoqueConsumer(ObjectMapper objectMapper) {
	    this.objectMapper = objectMapper;
	}
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
	private void consumidor(String jsonMessage) {
		try {
			EstoqueDTO estoqueDto = objectMapper.readValue(jsonMessage, EstoqueDTO.class);
			System.out.println(estoqueDto.codigoProduto);
			System.out.println(estoqueDto.quantidade);
			System.out.println("-------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
