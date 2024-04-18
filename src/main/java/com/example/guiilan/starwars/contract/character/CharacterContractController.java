package com.example.guiilan.starwars.contract.character;

import com.example.guiilan.starwars.contract.character.model.CharacterContractResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class CharacterContractController {
    private final CharacterContractFacade peopleContractFacade;

    @GetMapping("/character/{id}")
    public Mono<CharacterContractResponse> findPeopleById(@PathVariable(name = "id") Integer id) {
        return peopleContractFacade.contractResult(id);
    }

}
