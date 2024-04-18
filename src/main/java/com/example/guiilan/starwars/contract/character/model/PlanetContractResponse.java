package com.example.guiilan.starwars.contract.character.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlanetContractResponse {
    private String name;
    private String diameter;
    private String population;
}
