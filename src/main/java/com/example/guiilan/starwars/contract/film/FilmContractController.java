package com.example.guiilan.starwars.contract.film;

import com.example.guiilan.starwars.contract.film.model.FilmContractResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class FilmContractController {

    @GetMapping("/film/{id}")
    public Mono<FilmContractResponse> findFilmById(@PathVariable(name = "id") Integer id){
        return Mono.just(new FilmContractResponse("Feature not available ", id));
    }

}
