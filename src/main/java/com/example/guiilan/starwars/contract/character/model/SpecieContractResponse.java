package com.example.guiilan.starwars.contract.character.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecieContractResponse {
    private String name;
    private String language;
}
