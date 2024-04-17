package com.example.guiilan.starwars.impl.starship;

import com.example.guiilan.starwars.impl.starship.service.StarshipService;
import com.example.guiilan.starwars.integration.starship.model.StarshipResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StarshipImpFacede {

    private final StarshipService starshipService;

    public Mono<StarshipResponse> findStarshipByUrl(String url){ return starshipService.findStarshipByUrl(url);}

}
