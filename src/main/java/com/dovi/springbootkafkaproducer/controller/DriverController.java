package com.dovi.springbootkafkaproducer.controller;

import com.dovi.springbootkafkaproducer.dto.DriverLocationResponseDto;
import com.dovi.springbootkafkaproducer.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/driver")
@RequiredArgsConstructor
public class DriverController
{
    private final DriverService driverService;

    @GetMapping("/get_location")
    public ResponseEntity<DriverLocationResponseDto> getDriverLocation(
            @RequestParam(name = "driver_id") String driverId
    )
    {
        DriverLocationResponseDto response = driverService.fetchDriverLocation(driverId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
