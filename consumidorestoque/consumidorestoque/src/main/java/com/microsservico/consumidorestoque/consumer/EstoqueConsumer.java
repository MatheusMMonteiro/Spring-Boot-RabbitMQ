package com.microsservico.consumidorestoque.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.microsservicos.estoquepreco.constantes.RabbitMQConstantes;
import com.microsservicos.estoquepreco.dto.EstoqueDTO;

@Component
public class EstoqueConsumer {
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
	private void consumidor(EstoqueDTO estoqueDto) {
		System.out.println(estoqueDto.codigoProduto);
		System.out.println(estoqueDto.quantidade);
		System.out.println("-------------------------");
	}
}
