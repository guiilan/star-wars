package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.ContractResponse;
import com.example.guiilan.starwars.contract.model.PlanetContractResponse;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractMapper {

    public static ContractResponse mapperToResult(PeopleResponse people, PlanetResponse planet) {
        return Optional.ofNullable(people)
                .map(result -> ContractResponse.builder()
                        .name(result.getName())
                        .mass(result.getMass())
                        .birthYear(result.getBirthYear())
                        .height(result.getHeight())
                        .gender(result.getGender())
                        .planet(mapPlanet(planet))
                        .build())
                .orElse(null);
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
