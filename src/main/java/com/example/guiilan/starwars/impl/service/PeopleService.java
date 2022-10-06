package com.example.guiilan.starwars.impl.service;

import com.example.guiilan.starwars.integration.PeopleIntegration;
import com.example.guiilan.starwars.integration.model.PeopleResponse;
import com.example.guiilan.starwars.integration.model.PlanetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PeopleService {

    private final PeopleIntegration peopleIntegration;

    public Mono<PeopleResponse> findPeopleById(Integer id) {
        return peopleIntegration.findPeopleById(id);
    }

    public Mono<PlanetResponse> findPlanetById(Integer id) {
        return peopleIntegration.findPlanetById(id);
    }
}
