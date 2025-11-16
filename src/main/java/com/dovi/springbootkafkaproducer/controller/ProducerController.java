package com.dovi.springbootkafkaproducer.controller;

import com.dovi.springbootkafkaproducer.dto.LocationUpdateRequestDto;
import com.dovi.springbootkafkaproducer.dto.LocationUpdateResponseDto;
import com.dovi.springbootkafkaproducer.service.KafkaProducerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
@RequiredArgsConstructor
public class ProducerController
{
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/produce_location_update")
    public ResponseEntity<LocationUpdateResponseDto> produceLocationUpdate(
            @RequestBody @Valid LocationUpdateRequestDto request
    )
    {
        LocationUpdateResponseDto response = kafkaProducerService.pushLocationUpdateToKafka(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
