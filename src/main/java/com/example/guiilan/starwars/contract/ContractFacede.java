package com.example.guiilan.starwars.contract;

import com.example.guiilan.starwars.contract.model.ContractResponse;
import com.example.guiilan.starwars.impl.people.PeopleImplFacede;
import com.example.guiilan.starwars.contract.mapper.ContractMapper;
import com.example.guiilan.starwars.impl.planet.PlanetImplFacede;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ContractFacede {

    private final PeopleImplFacede peopleImplFacede;

    private final PlanetImplFacede planetImplFacede;

    public Mono<ContractResponse> contractResult(Integer id) {
        return Mono.zip(
                        peopleImplFacede.findPeopleById(id),
                        planetImplFacede.findPlanetById(id))
                .map(result -> ContractMapper.mapperToResult(result.getT1(), result.getT2()))
                .onErrorResume(error -> Mono.empty());
    }

}
