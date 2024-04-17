package com.example.guiilan.starwars.impl.specie;

import com.example.guiilan.starwars.impl.specie.service.SpecieService;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class SpecieImpFacade {

    private final SpecieService specieService;

    public  Mono<SpecieResponse> findSpecieByUrl(String url){ return specieService.findSpecieByUrl(url); }


}
