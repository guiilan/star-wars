package com.example.guiilan.starwars.impl.planet;

import com.example.guiilan.starwars.impl.planet.service.PlanetService;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PlanetImplFacade {

    private final PlanetService planetService;

    public Mono<PlanetResponse> findPlanetByUrl(String url) {
        return planetService.findPlanetByUrl(url);
    }
}

