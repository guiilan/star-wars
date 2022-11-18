package com.example.guiilan.starwars.contract.model;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponse {
    private String name;
    private String birthYear;
    private String gender;
    private String height;
    private String mass;
    private PlanetContractResponse planet;
}
