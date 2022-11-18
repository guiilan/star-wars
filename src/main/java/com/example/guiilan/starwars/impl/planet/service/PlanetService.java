package com.example.guiilan.starwars.impl.planet.service;

import com.example.guiilan.starwars.integration.planet.PlanetIntegration;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class PlanetService {

    private final PlanetIntegration planetIntegration;


    public Mono<PlanetResponse> findPlanetByUrl(String url) {
        return planetIntegration.findPlanetByUrl(url);
    }
}
