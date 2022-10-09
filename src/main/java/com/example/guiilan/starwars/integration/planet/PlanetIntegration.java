package com.example.guiilan.starwars.integration.planet;

import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PlanetIntegration {

    private final WebClient webClient;

    public PlanetIntegration(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://swapi.dev/api/").build();
    }

    public Mono<PlanetResponse> findPlanetById(Integer id) {
        return webClient
                .get()
                .uri("planets/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PlanetResponse.class)
                .onErrorResume(Mono::error);
    }

}
