package com.example.guiilan.starwars.integration.vehicles.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VehiclesResponse {
    private String name;
    private String model;
    private String manufacturer;
    @JsonProperty(value = "cost_in_credits")
    private String costInCredits;
    private String length;
    @JsonProperty(value = "max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    @JsonProperty(value = "cargo_capacity")
    private String cargoCapacity;
    private String consumables;
    @JsonProperty(value = "vehicle_class")
    private String vehicleClass;
}
