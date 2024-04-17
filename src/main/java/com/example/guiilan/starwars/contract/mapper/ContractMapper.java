package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.ContractResponse;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import com.example.guiilan.starwars.integration.starship.model.StarshipResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractMapper {

    public static ContractResponse mapperToResult(
            PeopleResponse people,
            PlanetResponse planet,
            SpecieResponse specie,
            List<StarshipResponse> starships
    ) {
        return Optional.ofNullable(people)
                .map(result -> ContractResponse.builder()
                        .name(result.getName())
                        .mass(result.getMass())
                        .birthYear(result.getBirthYear())
                        .height(result.getHeight())
                        .gender(result.getGender())
                        .starships(StarshipContractMapper.mapStarships(starships))
                        .planet(PlanetContractMapper.mapPlanet(planet))
                        .specie(SpecieContractMapper.mapSpecie(specie))
                        .build())
                .orElse(null);
    }

}
