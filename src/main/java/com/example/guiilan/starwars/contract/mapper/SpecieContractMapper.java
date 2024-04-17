package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.SpecieContractResponse;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;

import java.util.Optional;
public class SpecieContractMapper {
    public static SpecieContractResponse mapSpecie(SpecieResponse specieResponse){
        if(specieResponse.getName() == null) return null;
        return Optional.ofNullable(specieResponse)
                .map(result -> SpecieContractResponse.builder()
                        .name(result.getName())
                        .language(result.getLanguage())
                        .build())
                .orElse(null);
    }
}
