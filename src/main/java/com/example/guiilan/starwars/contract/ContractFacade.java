package com.example.guiilan.starwars.contract;

import com.example.guiilan.starwars.contract.model.ContractResponse;
import com.example.guiilan.starwars.impl.people.PeopleImplFacade;
import com.example.guiilan.starwars.contract.mapper.ContractMapper;
import com.example.guiilan.starwars.impl.planet.PlanetImplFacade;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ContractFacade {

    private final PeopleImplFacade peopleImplFacade;

    private final PlanetImplFacade planetImplFacade;

    public Mono<ContractResponse> contractResult(Integer id){
        return peopleImplFacade.findPeopleById(id)
                .flatMap(this::getPlanet);
    }

    private Mono<ContractResponse> getPlanet(PeopleResponse peopleResponse){
        return planetImplFacade.findPlanetByUrl(peopleResponse.getHomeWorld())
                .map(planet -> ContractMapper.mapperToResult(peopleResponse, planet));
    }


}
