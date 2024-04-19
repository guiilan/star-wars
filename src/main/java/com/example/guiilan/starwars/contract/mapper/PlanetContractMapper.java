package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.PlanetContractResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlanetContractMapper {

    public static List<PlanetContractResponse> mapPlanets(List<PlanetResponse> planetResponse){
        return planetResponse.stream()
                .map(PlanetContractMapper::mapPlanet)
                .collect(Collectors.toList());
    }

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
