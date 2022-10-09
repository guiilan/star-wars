package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.ContractResponse;
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
                        .people(people)
                        .planet(planet)
                        .build())
                .orElse(null);
    }

}
