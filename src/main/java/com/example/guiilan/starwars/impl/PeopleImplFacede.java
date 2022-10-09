package com.example.guiilan.starwars.impl;

import com.example.guiilan.starwars.contract.model.ContractResponse;
import com.example.guiilan.starwars.impl.mapper.PeopleMapper;
import com.example.guiilan.starwars.impl.service.PeopleService;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PeopleImplFacede {

    private final PeopleService peopleService;

    public Mono<ContractResponse> peopleResult(Integer peopleId, Integer planetId) {
        return Mono.zip(
                        findPeopleById(peopleId),
                        findPlanetById(planetId))
                .map(result -> PeopleMapper.mapperToResult(result.getT1(), result.getT2()))
                .onErrorResume(error -> Mono.empty());
    }

    public Mono<PeopleResponse> findPeopleById(Integer id) {
        return peopleService.findPeopleById(id);
    }

    public Mono<PlanetResponse> findPlanetById(Integer id) {
        return peopleService.findPlanetById(id);
    }

}
