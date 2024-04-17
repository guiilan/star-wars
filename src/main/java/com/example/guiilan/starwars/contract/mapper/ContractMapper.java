package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.ContractResponse;
import com.example.guiilan.starwars.contract.model.PlanetContractResponse;
import com.example.guiilan.starwars.contract.model.SpecieContractResponse;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractMapper {

    public static ContractResponse mapperToResult(PeopleResponse people, PlanetResponse planet, SpecieResponse specie) {
        return Optional.ofNullable(people)
                .map(result -> ContractResponse.builder()
                        .name(result.getName())
                        .mass(result.getMass())
                        .birthYear(result.getBirthYear())
                        .height(result.getHeight())
                        .gender(result.getGender())
                        .planet(mapPlanet(planet))
                        .specie(mapSpecie(specie))
                        .build())
                .orElse(null);
    }

    public static SpecieContractResponse mapSpecie(SpecieResponse specieResponse){
        if(specieResponse.getName() == null) return null;
        return Optional.ofNullable(specieResponse)
                .map(result -> SpecieContractResponse.builder()
                        .name(result.getName())
                        .language(result.getLanguage())
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
