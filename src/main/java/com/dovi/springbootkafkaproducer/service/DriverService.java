package com.dovi.springbootkafkaproducer.service;

import com.dovi.springbootkafkaproducer.dto.DriverLocationResponseDto;
import com.dovi.springbootkafkaproducer.utils.DriverLocationDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService
{
    public DriverLocationResponseDto fetchDriverLocation(String driverId)
    {
        DriverLocationDetail driverLocationDetail = new DriverLocationDetail();
        driverLocationDetail.setDriverId(driverId);
        driverLocationDetail.setLatitude( (int) (Math.random() * 100) );
        driverLocationDetail.setLongitude( (int) (Math.random() * 100) );

        ObjectMapper objectMapper = new ObjectMapper();

        try
        {
            String driverLocationDetails = objectMapper.writeValueAsString(driverLocationDetail);
            System.out.println("driverLocationDetails: " + driverLocationDetails);
            return DriverLocationResponseDto.builder()
                    .driverLocationDetails(driverLocationDetails)
                    .build();
        }
        catch (JsonProcessingException exc)
        {
            throw new RuntimeException(exc);
        }
    }
}
