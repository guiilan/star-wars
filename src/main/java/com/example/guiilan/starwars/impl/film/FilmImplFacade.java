package com.example.guiilan.starwars.impl.film;

import com.example.guiilan.starwars.impl.film.service.FilmService;
import com.example.guiilan.starwars.integration.film.model.FilmResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class FilmImplFacade {

    private final FilmService filmService;

    public Mono<FilmResponse> findFilmById(Integer id){ return filmService.findFilmById(id); }


}
