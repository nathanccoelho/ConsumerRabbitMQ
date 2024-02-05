package com.mewtwo.consumertest.connection;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mewtwo.consumertest.model.Installment;
import com.mewtwo.consumertest.model.Json;
import com.mewtwo.consumertest.model.Person;
import com.mewtwo.consumertest.model.Transaction;
import com.mewtwo.consumertest.model.repository.InstallmentRepository;
import com.mewtwo.consumertest.model.repository.PersonRepository;
import com.mewtwo.consumertest.model.repository.TransactionRepository;

@Component
public class RabbitMQConsumer {

	private PersonRepository personRepository;
	private InstallmentRepository installmentRepository;
	private TransactionRepository transactionRepository;

	private final ObjectMapper objectMapper;

	@Autowired
	public RabbitMQConsumer(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@RabbitListener(queues = "JSON")
	public void receiveMessage(String json) {
		try {
			// Desserializa o JSON em um objeto único
			Json jsonObject = objectMapper.readValue(json, Json.class);

			// Extrai os dados do objeto único para as três classes separadas
			Person person = jsonObject.getPerson();
			Transaction transaction = jsonObject.getTransaction();
			Installment installment = jsonObject.getInstallment();

			// Persiste os objetos no banco de dados
			personRepository.save(person);
			transactionRepository.save(transaction);
			installmentRepository.save(installment);
		} catch (Exception e) {
			e.printStackTrace();
			// Lida com exceções, se necessário
		}
	}
}