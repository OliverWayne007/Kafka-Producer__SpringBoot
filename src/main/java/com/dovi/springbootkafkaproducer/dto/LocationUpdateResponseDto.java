package com.dovi.springbootkafkaproducer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class LocationUpdateResponseDto
{
    private String message;
}
