package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.FilmContractResponse;
import com.example.guiilan.starwars.integration.film.model.FilmResponse;
import com.example.guiilan.starwars.integration.planet.model.PlanetResponse;
import com.example.guiilan.starwars.integration.specie.model.SpecieResponse;
import com.example.guiilan.starwars.integration.starship.model.StarshipResponse;
import com.example.guiilan.starwars.integration.vehicles.model.VehiclesResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilmContractMapper {

    public static FilmContractResponse mapperToResult(
            FilmResponse filmResponse,
            List<PlanetResponse> planetResponse,
            List<SpecieResponse> specieResponse,
            List<StarshipResponse> starshipResponse,
            List<VehiclesResponse> vehiclesResponses
    ) {
        return Optional.ofNullable(filmResponse)
                .map(result -> FilmContractResponse.builder()
                        .director(result.getDirector())
                        .planets(PlanetContractMapper.mapPlanets(planetResponse))
                        .starships(StarshipContractMapper.mapStarships(starshipResponse))
                        .species(SpecieContractMapper.mapSpecies(specieResponse))
                        .openingCrawl(result.getOpeningCrawl())
                        .title(result.getTitle())
                        .producer(result.getProducer())
                        .vehicles(VehicleContractMapper.mapperVehicles(vehiclesResponses))
                        .releaseDate(result.getReleaseDate())
                        .build()
                )
                .orElse(null);
    }

}
