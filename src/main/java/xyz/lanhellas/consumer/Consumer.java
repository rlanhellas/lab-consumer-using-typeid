package xyz.lanhellas.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
@KafkaListener(topics = "movimentacoes_03")
public class Consumer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@KafkaHandler
	public void consume(@Payload TED ted) {
		logger.info("TED de {} para {} no valor de  {}", ted.getContaOrigem(), ted.getContaDestino(), ted.getValor());
	}

	@KafkaHandler
	public void consume(@Payload SaqueAtm saque) {
		logger.info("Sque no ATM {} da conta {} no valor de  {}", saque.getNumeroAtm(), saque.getConta(),
				saque.getValorSacado());
	}

}
