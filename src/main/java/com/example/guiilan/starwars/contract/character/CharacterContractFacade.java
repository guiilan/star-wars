package com.example.guiilan.starwars.contract.character;

import com.example.guiilan.starwars.contract.mapper.CharacterContractMapper;
import com.example.guiilan.starwars.contract.model.CharacterContractResponse;
import com.example.guiilan.starwars.impl.people.PeopleImplFacade;
import com.example.guiilan.starwars.impl.planet.PlanetImplFacade;
import com.example.guiilan.starwars.impl.specie.SpecieImpFacade;
import com.example.guiilan.starwars.impl.starship.StarshipImpFacede;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import com.example.guiilan.starwars.integration.starship.model.StarshipResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple4;

import java.util.List;


@AllArgsConstructor
@Service
public class CharacterContractFacade {

    private final PeopleImplFacade peopleImplFacade;

    private final PlanetImplFacade planetImplFacade;

    private final SpecieImpFacade specieImpFacade;

    private final StarshipImpFacede starshipImpFacede;

    public Mono<CharacterContractResponse> contractResult(Integer id) {
        return peopleImplFacade.findPeopleById(id)
                .flatMap(this::zippingContract)
                .map(tuple -> CharacterContractMapper.mapperToResult(tuple.getT1(),tuple.getT2(), tuple.getT3(), tuple.getT4()));
    }

    private Mono<Tuple4<PeopleResponse, PlanetResponse, SpecieResponse, List<StarshipResponse>>> zippingContract(PeopleResponse peopleResponse){
        return Mono.zip(
                Mono.just(peopleResponse),
                getPlanet(peopleResponse),
                getSpecie(peopleResponse),
                getStarships(peopleResponse)
        );
    }

    public Mono<List<StarshipResponse>> getStarships(PeopleResponse peopleResponse) {
        return Flux.fromIterable(peopleResponse.getStarships())
                .flatMap(starshipImpFacede::findStarshipByUrl)
                .collectList();
    }

    public Mono<PlanetResponse> getPlanet(PeopleResponse peopleResponse) {
        return planetImplFacade.findPlanetByUrl(peopleResponse.getHomeWorld());
    }

    public Mono<SpecieResponse> getSpecie(PeopleResponse peopleResponse) {
        if (peopleResponse.getSpecies().isEmpty()) return Mono.just(new SpecieResponse());
        return specieImpFacade.findSpecieByUrl(peopleResponse.getSpecies().get(0));
    }


}
