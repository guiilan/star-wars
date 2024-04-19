package com.example.guiilan.starwars.contract.film;

import com.example.guiilan.starwars.contract.mapper.FilmContractMapper;
import com.example.guiilan.starwars.contract.model.FilmContractResponse;
import com.example.guiilan.starwars.impl.film.FilmImplFacade;
import com.example.guiilan.starwars.impl.planet.PlanetImplFacade;
import com.example.guiilan.starwars.impl.specie.SpecieImpFacade;
import com.example.guiilan.starwars.impl.starship.StarshipImpFacede;
import com.example.guiilan.starwars.integration.film.model.FilmResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import com.example.guiilan.starwars.integration.starship.model.StarshipResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple4;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmContractFacade {

    private final FilmImplFacade filmImplFacade;

    private final PlanetImplFacade planetImplFacade;

    private final SpecieImpFacade specieImpFacade;

    private final StarshipImpFacede starshipImpFacede;


    public Mono<FilmContractResponse> findFilmById(Integer id){
        return filmImplFacade.findFilmById(id)
                .flatMap(this::zippingContract)
                .map(tuple -> FilmContractMapper.mapperToResult(tuple.getT1(), tuple.getT2(), tuple.getT3(), tuple.getT4()));
    }

    private Mono<Tuple4<FilmResponse, List<PlanetResponse>, List<SpecieResponse>, List<StarshipResponse>>> zippingContract(FilmResponse filmResponse){
        return Mono.zip(
                Mono.just(filmResponse),
                getPlanet(filmResponse),
                getSpecie(filmResponse),
                getStarships(filmResponse)
        );
    }

    public Mono<List<StarshipResponse>> getStarships(FilmResponse filmResponse){
        return Flux.fromIterable(filmResponse.getStarships())
                .flatMap(starshipImpFacede::findStarshipByUrl)
                .collectList();
    }

    public Mono<List<PlanetResponse>> getPlanet(FilmResponse filmResponse){
        return Flux.fromIterable(filmResponse.getPlanets())
                .flatMap(planetImplFacade::findPlanetByUrl)
                .collectList();
    }

    public Mono<List<SpecieResponse>> getSpecie(FilmResponse filmResponse){
        return Flux.fromIterable(filmResponse.getSpecies())
                .flatMap(specieImpFacade::findSpecieByUrl)
                .collectList();
    }



}
