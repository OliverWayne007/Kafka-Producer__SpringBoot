package com.dovi.springbootkafkaproducer.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LocationUpdateRequestDto
{
    @NotNull(message = "driver_id is a required field")
    private String driverId;

    @NotNull(message = "latitude is a required field")
    private Integer latitude;

    @NotNull(message = "longitude is a required field")
    private Integer longitude;
}
