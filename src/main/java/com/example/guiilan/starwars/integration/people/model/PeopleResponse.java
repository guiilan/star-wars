package com.example.guiilan.starwars.integration.people.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleResponse {
    private String name;
    private String mass;
    @JsonProperty(value = "birth_year")
    private String birthYear;
    private String height;
    private String gender;
    @JsonProperty(value = "homeworld")
    private String homeWorld;
    private List<String> species;
    private List<String> starships;
}
