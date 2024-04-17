package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.StarshipContractResponse;
import com.example.guiilan.starwars.integration.starship.model.StarshipResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StarshipContractMapper {
    public static List<StarshipContractResponse> mapStarships(List<StarshipResponse> starshipResponses) {
        return starshipResponses.stream()
                .map(StarshipContractMapper::mapStarship)
                .collect(Collectors.toList());
    }

    private static StarshipContractResponse mapStarship(StarshipResponse starshipResponse) {
        return Optional.ofNullable(starshipResponse)
                .map(result -> StarshipContractResponse.builder()
                        .crew(result.getCrew())
                        .length(result.getLength())
                        .name(result.getName())
                        .manufacturer(result.getManufacturer())
                        .costInCredits(result.getCostInCredits())
                        .maxAtmospheringSpeed(result.getMaxAtmospheringSpeed())
                        .passengers(result.getPassengers())
                        .model(result.getModel())
                        .build())
                .orElse(null);
    }
}
