package com.example.guiilan.starwars.impl.people.service;

import com.example.guiilan.starwars.integration.people.PeopleIntegration;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PeopleService {

    private final PeopleIntegration peopleIntegration;

    public Mono<PeopleResponse> findPeopleById(Integer id) {
        return peopleIntegration.findPeopleById(id);
    }

}
