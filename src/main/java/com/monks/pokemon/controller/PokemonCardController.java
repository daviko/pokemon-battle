package com.monks.pokemon.controller;

import com.monks.pokemon.model.api.PokemonCard;
import com.monks.pokemon.model.api.PokemonCardResponse;
import com.monks.pokemon.model.api.PokemonData;
import com.monks.pokemon.service.PokemonCardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonCardController {

    private final PokemonCardService pokemonCardService;

    @Autowired
    public PokemonCardController(PokemonCardService pokemonCardService) {
        this.pokemonCardService = pokemonCardService;
    }

    @GetMapping("/cards")
    public Mono<ResponseEntity<List<PokemonData>>> getAllCards() {
        return pokemonCardService.getAllCards()
            .map(PokemonCardResponse::getData)
            .map(ResponseEntity::ok)
            .onErrorResume(Exception.class,
                e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }

    @GetMapping("/cards/{id}")
    public Mono<ResponseEntity<PokemonCard>> getCardById(@PathVariable("id") String cardId) {
        return pokemonCardService.getCardById(cardId)
            .map(ResponseEntity::ok)
            .onErrorResume(Exception.class,
                e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }
}
