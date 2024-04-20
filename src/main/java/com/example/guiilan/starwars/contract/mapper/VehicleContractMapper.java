package com.example.guiilan.starwars.contract.mapper;

import com.example.guiilan.starwars.contract.model.VehicleContractResponse;
import com.example.guiilan.starwars.integration.vehicles.model.VehiclesResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VehicleContractMapper {

    public static List<VehicleContractResponse> mapperVehicles(List<VehiclesResponse> vehicles){
        return vehicles.stream()
                .map(VehicleContractMapper::mapperVehicle)
                .collect(Collectors.toList());
    }

    public static VehicleContractResponse mapperVehicle(VehiclesResponse vehicle){
        return Optional.ofNullable(vehicle)
                .map(result -> VehicleContractResponse.builder()
                        .crew(result.getCrew())
                        .maxAtmospheringSpeed(result.getMaxAtmospheringSpeed())
                        .length(result.getLength())
                        .name(result.getName())
                        .model(result.getModel())
                        .manufacturer(result.getManufacturer())
                        .costInCredits(result.getCostInCredits())
                        .passengers(result.getPassengers())
                        .cargoCapacity(result.getCargoCapacity())
                        .consumables(result.getConsumables())
                        .vehicleClass(result.getVehicleClass())
                        .build()
                ).orElse(null);
    }
}
