package com.example.guiilan.starwars.integration.starship.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StarshipResponse {
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
}
