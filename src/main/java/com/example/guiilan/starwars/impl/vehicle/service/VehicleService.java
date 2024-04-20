package com.example.guiilan.starwars.impl.vehicle.service;

import com.example.guiilan.starwars.integration.vehicles.VehiclesIntegration;
import com.example.guiilan.starwars.integration.vehicles.model.VehiclesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehiclesIntegration vehiclesIntegration;

    public Mono<VehiclesResponse> findVehicleByUrl(String url){
        return vehiclesIntegration.findVehicleByUrl(url);
    }


}
