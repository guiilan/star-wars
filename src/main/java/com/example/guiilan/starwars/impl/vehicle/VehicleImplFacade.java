package com.example.guiilan.starwars.impl.vehicle;

import com.example.guiilan.starwars.impl.vehicle.service.VehicleService;
import com.example.guiilan.starwars.integration.vehicles.model.VehiclesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class VehicleImplFacade {

    private final VehicleService vehicleService;

    public Mono<VehiclesResponse> findVehicleByUrl(String url){
        return vehicleService.findVehicleByUrl(url);
    }

}
