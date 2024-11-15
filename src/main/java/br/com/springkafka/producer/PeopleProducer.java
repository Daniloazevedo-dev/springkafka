package br.com.springkafka.producer;

import br.com.springkafka.People;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PeopleProducer {

    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, People> kafkaTemplate;

    public void sendMessage(People people) {
        try {
            kafkaTemplate.send(topicName, (String) people.getId(), people);
            log.info("Mensagem enviada: {}", people);
        } catch (Exception e) {
            log.error("Erro ao enviar mensagem: {}", e.getMessage());
        }
    }
}
