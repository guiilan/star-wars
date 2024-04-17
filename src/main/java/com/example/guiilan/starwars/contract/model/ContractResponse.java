package com.example.guiilan.starwars.contract.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContractResponse {
    private String name;
    private String birthYear;
    private String gender;
    private String height;
    private String mass;
    private PlanetContractResponse planet;
    private SpecieContractResponse specie;
    private List<StarshipContractResponse> starships;
}
