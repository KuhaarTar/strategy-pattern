package com.iot.service.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("console")
public class ConsoleExporterStrategy implements ExporterStrategy {

    @Override
    public void exportDataToSource(String data) {
        log.info("Exporting data to console: {}", data);
    }
}
