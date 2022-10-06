package com.example.guiilan.starwars.contract;

import com.example.guiilan.starwars.contract.model.ContractResponse;
import com.example.guiilan.starwars.impl.PeopleImplFacede;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class PeopleContractFacede {

    private final PeopleImplFacede peopleImplFacede;

    public Mono<ContractResponse> findPeopleById(Integer id) {
        return peopleImplFacede.peopleResult(id, id);
    }

}
