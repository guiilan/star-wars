package com.example.guiilan.starwars.contract.film;

import com.example.guiilan.starwars.contract.model.FilmContractResponse;
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

    private final FilmContractFacade filmContractFacade;

    @GetMapping("/film/{id}")
    public Mono<FilmContractResponse> findFilmById(@PathVariable(name = "id") Integer id){
        return filmContractFacade.findFilmById(id);
    }

}
