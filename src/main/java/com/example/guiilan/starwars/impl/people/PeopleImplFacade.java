package com.example.guiilan.starwars.impl.people;

import com.example.guiilan.starwars.impl.people.service.PeopleService;
import com.example.guiilan.starwars.integration.people.model.PeopleResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PeopleImplFacade {

    private final PeopleService peopleService;

    public Mono<PeopleResponse> findPeopleById(Integer id) {
        return peopleService.findPeopleById(id);
    }

}
