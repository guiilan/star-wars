package com.example.guiilan.starwars.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlanetResponse {
    private String name;
    private String diameter;
    private String population;
}
