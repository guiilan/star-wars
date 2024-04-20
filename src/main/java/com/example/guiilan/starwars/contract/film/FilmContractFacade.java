package com.example.guiilan.starwars.contract.film;

import com.example.guiilan.starwars.contract.mapper.FilmContractMapper;
import com.example.guiilan.starwars.contract.model.FilmContractResponse;
import com.example.guiilan.starwars.impl.film.FilmImplFacade;
import com.example.guiilan.starwars.impl.planet.PlanetImplFacade;
import com.example.guiilan.starwars.impl.specie.SpecieImpFacade;
import com.example.guiilan.starwars.impl.starship.StarshipImpFacede;
import com.example.guiilan.starwars.impl.vehicle.VehicleImplFacade;
import com.example.guiilan.starwars.integration.film.model.FilmResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import com.example.guiilan.starwars.integration.starship.model.StarshipResponse;
import com.example.guiilan.starwars.integration.vehicles.model.VehiclesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple5;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmContractFacade {

    private final FilmImplFacade filmImplFacade;

    private final PlanetImplFacade planetImplFacade;

    private final SpecieImpFacade specieImpFacade;

    private final StarshipImpFacede starshipImpFacede;

    private final VehicleImplFacade vehicleImplFacade;


    public Mono<FilmContractResponse> findFilmById(Integer id){
        return filmImplFacade.findFilmById(id)
                .flatMap(this::zippingContract)
                .map(tuple -> FilmContractMapper.mapperToResult(
                        tuple.getT1(),
                        tuple.getT2(),
                        tuple.getT3(),
                        tuple.getT4(),
                        tuple.getT5()
                ));
    }

    private Mono<Tuple5<
            FilmResponse,
            List<PlanetResponse>,
            List<SpecieResponse>,
            List<StarshipResponse>,
            List<VehiclesResponse>
            >> zippingContract(FilmResponse filmResponse){
        return Mono.zip(
                Mono.just(filmResponse),
                getPlanet(filmResponse),
                getSpecie(filmResponse),
                getStarships(filmResponse),
                getVehicles(filmResponse)
        );
    }

    private Mono<List<VehiclesResponse>> getVehicles(FilmResponse filmResponse){
        return Flux.fromIterable(filmResponse.getVehicles())
                .flatMap(vehicleImplFacade::findVehicleByUrl)
                .collectList();
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
