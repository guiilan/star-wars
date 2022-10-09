package com.example.guiilan.starwars.integration.people;

import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
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

}
