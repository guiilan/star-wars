package com.example.guiilan.starwars.impl.service;

import com.example.guiilan.starwars.integration.people.PeopleIntegration;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import com.example.guiilan.starwars.integration.planet.PlanetIntegration;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PeopleService {

    private final PeopleIntegration peopleIntegration;

    private final PlanetIntegration planetIntegration;

    public Mono<PeopleResponse> findPeopleById(Integer id) {
        return peopleIntegration.findPeopleById(id);
    }

    public Mono<PlanetResponse> findPlanetById(Integer id) {
        return planetIntegration.findPlanetById(id);
    }
}
