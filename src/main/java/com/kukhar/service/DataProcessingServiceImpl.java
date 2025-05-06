package com.kukhar.service;

import com.kukhar.service.strategy.ExporterStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataProcessingServiceImpl implements DataProcessingService {

    private final ExporterStrategy exporterStrategy;

    public void processDataset() {
        try {
            Path path = Path.of(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("dataset.csv")).toURI());

            try (var lines = java.nio.file.Files.lines(path)) {
                lines.forEach(exporterStrategy::exportDataToSource);
            }

        } catch (URISyntaxException | NullPointerException | IOException e) {
            log.error("Failed to load dataset.csv", e);
        }
    }

}