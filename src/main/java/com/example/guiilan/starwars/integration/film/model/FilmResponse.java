package com.example.guiilan.starwars.integration.film.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FilmResponse {
    private String title;
    @JsonProperty(value = "opening_crawl")
    private String openingCrawl;
    private String director;
    private String producer;
    @JsonProperty(value = "release_date")
    private String releaseDate;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
}
