package com.example.guiilan.starwars.impl.film.service;

import com.example.guiilan.starwars.integration.film.FilmIntegration;
import com.example.guiilan.starwars.integration.film.model.FilmResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmIntegration filmIntegration;

    public Mono<FilmResponse> findFilmById(Integer id){ return filmIntegration.findFilmById(id); }

}
