package com.dovi.springbootkafkaproducer.service;

import com.dovi.springbootkafkaproducer.dto.LocationUpdateRequestDto;
import com.dovi.springbootkafkaproducer.dto.LocationUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public LocationUpdateResponseDto pushLocationUpdateToKafka(LocationUpdateRequestDto request)
    {
        String driverId = request.getDriverId();
        int latitude = request.getLatitude();
        int longitude = request.getLongitude();

        String location = "(" + latitude + "," + longitude + ")";

        log.info("Pushing location update from producer service to kafka started.....");

        kafkaTemplate.send("location-updates", driverId, location);

        log.info("Pushing location update from producer service to kafka complete !");

        return LocationUpdateResponseDto.builder()
                .message("Location update pushed successfully !")
                .build();
    }
}
