package com.example.guiilan.starwars.integration.specie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SpecieResponse {
    private String name;
    private String language;
}
