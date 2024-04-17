package com.example.guiilan.starwars.impl.starship.service;

import com.example.guiilan.starwars.integration.starship.StarshipIntegration;
import com.example.guiilan.starwars.integration.starship.model.StarshipResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class StarshipService {

    private final StarshipIntegration starshipIntegration;

    public Mono<StarshipResponse> findStarshipByUrl(String url){ return starshipIntegration.findStarshipByUrl(url);}

}
