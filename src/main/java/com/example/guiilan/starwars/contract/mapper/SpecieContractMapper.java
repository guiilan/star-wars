package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.SpecieContractResponse;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecieContractMapper {

    public static List<SpecieContractResponse> mapSpecies(List<SpecieResponse> specieResponses){
        return specieResponses.stream()
                .map(SpecieContractMapper::mapSpecie)
                .collect(Collectors.toList());
    }

    public static SpecieContractResponse mapSpecie(SpecieResponse specieResponse){
        if(specieResponse.getName() == null) return null;
        return Optional.of(specieResponse)
                .map(result -> SpecieContractResponse.builder()
                        .name(result.getName())
                        .language(result.getLanguage())
                        .build())
                .orElse(null);
    }
}
