package com.example.guiilan.starwars.integration;

import com.example.guiilan.starwars.integration.model.PeopleResponse;
import com.example.guiilan.starwars.integration.model.PlanetResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PeopleIntegration {

    private final WebClient webClient;

    public PeopleIntegration(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://swapi.dev/api/").build();
    }

    public Mono<PeopleResponse> findPeopleById(Integer id) {
        return webClient
                .get()
                .uri("people/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PeopleResponse.class)
                .onErrorResume(Mono::error);
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
