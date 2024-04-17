package com.example.guiilan.starwars.integration.specie;

import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SpecieIntegration {

    private final WebClient webClient;

    public SpecieIntegration(WebClient.Builder builder) {
        webClient = builder.build();
    }

    public Mono<SpecieResponse> findSpecieByUrl(String url) {
        return webClient
                .get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(SpecieResponse.class)
                .onErrorResume(Mono::error);
    }
}
