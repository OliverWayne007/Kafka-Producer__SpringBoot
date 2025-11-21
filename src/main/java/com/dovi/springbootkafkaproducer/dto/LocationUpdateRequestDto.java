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
    @NotNull(message = "driver_location_details is a required field")
    private String driverLocationDetails;
}
