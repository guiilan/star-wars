package com.example.guiilan.starwars.contract.model;

import com.example.guiilan.starwars.integration.model.PeopleResponse;
import com.example.guiilan.starwars.integration.model.PlanetResponse;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponse {
    private PeopleResponse people;
    private PlanetResponse planet;
}
