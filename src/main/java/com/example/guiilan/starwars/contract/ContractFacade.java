package com.example.guiilan.starwars.contract;

import com.example.guiilan.starwars.contract.model.ContractResponse;
import com.example.guiilan.starwars.impl.people.PeopleImplFacade;
import com.example.guiilan.starwars.contract.mapper.ContractMapper;
import com.example.guiilan.starwars.impl.planet.PlanetImplFacade;
import com.example.guiilan.starwars.impl.specie.SpecieImpFacade;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ContractFacade {

    private final PeopleImplFacade peopleImplFacade;

    private final PlanetImplFacade planetImplFacade;

    private final SpecieImpFacade specieImpFacade;

    public Mono<ContractResponse> contractResult(Integer id) {
        return peopleImplFacade.findPeopleById(id)
                .flatMap((PeopleResponse peopleResponse) ->
                        Mono.zip(
                                getPlanet(peopleResponse),
                                getSpecie(peopleResponse),
                                (planetResult, specieResult) -> ContractMapper.mapperToResult(peopleResponse, planetResult, specieResult)
                        )
                );
    }

    public Mono<PlanetResponse> getPlanet(PeopleResponse peopleResponse) {
        return planetImplFacade.findPlanetByUrl(peopleResponse.getHomeWorld());
    }

    public Mono<SpecieResponse> getSpecie(PeopleResponse peopleResponse) {
        if (peopleResponse.getSpecies().isEmpty()) return Mono.empty();
        return specieImpFacade.findSpecieByUrl(peopleResponse.getSpecies().get(0));
    }


}
