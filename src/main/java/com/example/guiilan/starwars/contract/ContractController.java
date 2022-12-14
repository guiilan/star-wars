package com.example.guiilan.starwars.contract;

import com.example.guiilan.starwars.contract.model.ContractResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class ContractController {
    private final ContractFacade peopleContractFacade;

    @GetMapping("/{id}")
    public Mono<ContractResponse> findPeopleById(@PathVariable(name = "id") Integer id) {
        return peopleContractFacade.contractResult(id);
    }

}
