package com.monks.pokemon.repository;

import com.monks.pokemon.model.Attack;
import com.monks.pokemon.model.Pokemon;
import com.monks.pokemon.model.api.PokemonCardResponse;
import com.monks.pokemon.util.JsonReader;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class PokemonRepository {

    private final JsonReader jsonReader;
    private List<Pokemon> pokemons;

    @Autowired
    public PokemonRepository(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
        loadPokemons();
    }

    private void loadPokemons() {
        PokemonCardResponse pokemonCardResponse = jsonReader.readJsonFile();
        pokemons = new ArrayList<>();
        final int[] attackId = {1};

        pokemonCardResponse.getData()
            .stream()
            .filter(pokemonData -> pokemonData.getAttacks() != null && !pokemonData.getAttacks().isEmpty())
            .forEach(pokemonData -> {
                Attack attack = Attack.builder()
                    .id(attackId[0])
                    .name(pokemonData.getAttacks().get(0).getName())
                    .text(pokemonData.getAttacks().get(0).getText())
                    .damage(getNumberFromString(pokemonData.getAttacks().get(0).getDamage()))
                    .build();

                Pokemon pokemon = Pokemon.builder()
                    .id(pokemonData.getId())
                    .name(pokemonData.getName())
                    .hp(getNumberFromString(pokemonData.getHp()))
                    .attack(attack)
                    .build();

                pokemons.add(pokemon);
                attackId[0]++;
            });
    }

    private Integer getNumberFromString(String text) {
        try {
            return Integer.parseInt(text.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
