package com.kukhar.config;

import com.kukhar.service.strategy.ExporterStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    @Value("${application.output.type}")
    private String outputType;

    private final Map<String, ExporterStrategy> strategies;

    @Bean
    @Primary
    public ExporterStrategy outputStrategy() {
        return strategies.get(outputType);
    }
}

