package com.example.guiilan.starwars.integration.film;

import com.example.guiilan.starwars.integration.film.model.FilmResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FilmIntegration {

    private final WebClient webClient;

    public FilmIntegration(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://swapi.dev/api/").build();
    }

    public Mono<FilmResponse> findFilmById(Integer id){
        return webClient
                .get()
                .uri("films/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FilmResponse.class)
                .onErrorResume(Mono::error);
    }

}
