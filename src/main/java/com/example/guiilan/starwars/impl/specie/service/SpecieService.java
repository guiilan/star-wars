package com.example.guiilan.starwars.impl.specie.service;

import com.example.guiilan.starwars.integration.specie.SpecieIntegration;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class SpecieService {

    private final SpecieIntegration specieIntegration;

    public Mono<SpecieResponse> findSpecieByUrl(String url){ return specieIntegration.findSpecieByUrl(url); }
}
