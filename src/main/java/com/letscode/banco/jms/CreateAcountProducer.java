package com.letscode.banco.jms;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAcountProducer {
    @Value("${kafka.topic.name}")
    private String topicName;
    private final KafkaTemplate<String, AccountJms> kafkaTemplate;

    public void send(AccountJms accountJms){
        kafkaTemplate.send(topicName, accountJms);
    }
}
