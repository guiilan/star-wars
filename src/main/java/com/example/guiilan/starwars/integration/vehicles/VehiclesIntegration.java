package com.example.guiilan.starwars.integration.vehicles;

import com.example.guiilan.starwars.integration.vehicles.model.VehiclesResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class VehiclesIntegration {

    private final WebClient webClient;

    public VehiclesIntegration(WebClient.Builder builder) {
        webClient = builder.build();
    }

    public Mono<VehiclesResponse> findVehicleByUrl(String url){
        return webClient
                .get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(VehiclesResponse.class)
                .onErrorResume(Mono::error);
    }
}
