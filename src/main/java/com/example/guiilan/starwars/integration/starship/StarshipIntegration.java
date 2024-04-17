package com.example.guiilan.starwars.integration.starship;

import com.example.guiilan.starwars.integration.starship.model.StarshipResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StarshipIntegration {

    private final WebClient webClient;

    public StarshipIntegration(WebClient.Builder builder) {
        webClient = builder.build();
    }

    public Mono<StarshipResponse> findStarshipByUrl(String url){
        return webClient
                .get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(StarshipResponse.class)
                .onErrorResume(Mono::error);
    }

}
