package com.monks.pokemon.service;

import com.monks.pokemon.model.api.PokemonCard;
import com.monks.pokemon.model.api.PokemonCardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PokemonCardService {

    private static final String POKEMON_CARDS_API_URL = "https://api.pokemontcg.io/v2/cards";

    private final WebClient webClient;

    @Autowired
    public PokemonCardService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<PokemonCardResponse> getAllCards() {
        return webClient.get()
            .uri(POKEMON_CARDS_API_URL)
            .retrieve()
            .bodyToMono(PokemonCardResponse.class);
    }

    public Mono<PokemonCard> getCardById(String cardId) {
        return webClient.get()
            .uri(POKEMON_CARDS_API_URL + "/{id}", cardId)
            .retrieve()
            .bodyToMono(PokemonCard.class);
    }
}
