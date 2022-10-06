package com.example.guiilan.starwars.impl.mapper;
import com.example.guiilan.starwars.contract.model.ContractResponse;
import com.example.guiilan.starwars.integration.model.PeopleResponse;
import com.example.guiilan.starwars.integration.model.PlanetResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PeopleMapper {

    public static ContractResponse mapperToResult(PeopleResponse people, PlanetResponse planet){
        return Optional.ofNullable(people)
                .map(result -> ContractResponse.builder()
                        .name(result.getName())
                        .mass(result.getMass())
                        .birthYear(result.getBirthYear())
                        .planet(planet)
                        .build())
                .orElse(null);
    }

}
