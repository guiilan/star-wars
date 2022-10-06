package com.example.guiilan.starwars.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleResponse {
    private String name;
    private String mass;
    @JsonProperty(value = "birth_year")
    private String birthYear;
}
