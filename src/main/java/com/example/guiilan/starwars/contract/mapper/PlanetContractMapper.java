package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.PlanetContractResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;

import java.util.Optional;

public class PlanetContractMapper {

    public static PlanetContractResponse mapPlanet(PlanetResponse planetResponse) {
        return Optional.ofNullable(planetResponse)
                .map(result -> PlanetContractResponse.builder()
                        .diameter(result.getDiameter())
                        .population(result.getPopulation())
                        .diameter(result.getDiameter())
                        .name(result.getName())
                        .build())
                .orElse(null);
    }
}
