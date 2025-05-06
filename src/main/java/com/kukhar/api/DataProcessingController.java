package com.kukhar.api;

import com.kukhar.service.DataProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/data")
@RestController
@RequiredArgsConstructor
public class DataProcessingController {

    private final DataProcessingService dataProcessingService;

    @PostMapping
    public ResponseEntity<Void> processData() {
        dataProcessingService.processDataset();
        return ResponseEntity.ok().build();
    }
}
