package com.iot.service.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("kafka")
@RequiredArgsConstructor
public class KafkaExporterStrategy implements ExporterStrategy {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "iot-data";

    @Override
    public void exportDataToSource(String data) {
        kafkaTemplate.send(TOPIC, data);
    }
}
