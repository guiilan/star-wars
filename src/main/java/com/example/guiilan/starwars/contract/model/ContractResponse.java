package com.example.guiilan.starwars.contract.model;

import com.example.guiilan.starwars.integration.model.PlanetResponse;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponse {
    private String name;
    private String mass;
    private String birthYear;
    private PlanetResponse planet;
}
