package com.example.guiilan.starwars.contract.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmContractResponse {

    private String title;
    private String openingCrawl;
    private String director;
    private String producer;
    private String releaseDate;
    private List<CharacterContractResponse> characters;
    private List<PlanetContractResponse> planets;
    private List<StarshipContractResponse> starships;
    private List<SpecieContractResponse> species;
    private List<VehicleContractResponse> vehicles;

}
