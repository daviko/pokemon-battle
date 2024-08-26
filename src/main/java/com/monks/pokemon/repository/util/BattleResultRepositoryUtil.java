package com.monks.pokemon.repository.util;

import com.monks.pokemon.model.BattleResult;
import com.monks.pokemon.model.Player;
import com.monks.pokemon.model.Pokemon;
import com.monks.pokemon.repository.PokemonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BattleResultRepositoryUtil {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public BattleResultRepositoryUtil(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<BattleResult> createBattleResults() {
        Player player1 = Player.builder()
            .id(1)
            .name("Ash Ketchum")
            .build();

        Player player2 = Player.builder()
            .id(2)
            .name("Gary Oak")
            .build();

        Pokemon pokemon1 = pokemonRepository.getPokemons().get(0);
        Pokemon pokemon2 = pokemonRepository.getPokemons().get(1);
        Pokemon pokemon3 = pokemonRepository.getPokemons().get(2);
        Pokemon pokemon4 = pokemonRepository.getPokemons().get(3);
        Pokemon pokemon5 = pokemonRepository.getPokemons().get(4);
        Pokemon pokemon6 = pokemonRepository.getPokemons().get(5);
        Pokemon pokemon7 = pokemonRepository.getPokemons().get(6);
        Pokemon pokemon8 = pokemonRepository.getPokemons().get(7);
        Pokemon pokemon9 = pokemonRepository.getPokemons().get(8);
        Pokemon pokemon10 = pokemonRepository.getPokemons().get(9);

        BattleResult battleResult1 = BattleResult.builder()
            .id(1)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon1)
            .pokemonPlayer2(pokemon2)
            .finalHpPokemon1(0)
            .finalHpPokemon2(50)
            .winner(player2)
            .build();

        BattleResult battleResult2 = BattleResult.builder()
            .id(2)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon3)
            .pokemonPlayer2(pokemon4)
            .finalHpPokemon1(100)
            .finalHpPokemon2(0)
            .winner(player1)
            .build();

        BattleResult battleResult3 = BattleResult.builder()
            .id(3)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon5)
            .pokemonPlayer2(pokemon6)
            .finalHpPokemon1(0)
            .finalHpPokemon2(30)
            .winner(player2)
            .build();

        BattleResult battleResult4 = BattleResult.builder()
            .id(4)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon7)
            .pokemonPlayer2(pokemon8)
            .finalHpPokemon1(60)
            .finalHpPokemon2(0)
            .winner(player1)
            .build();

        BattleResult battleResult5 = BattleResult.builder()
            .id(5)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon9)
            .pokemonPlayer2(pokemon10)
            .finalHpPokemon1(0)
            .finalHpPokemon2(90)
            .winner(player2)
            .build();

        BattleResult battleResult6 = BattleResult.builder()
            .id(6)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon1)
            .pokemonPlayer2(pokemon2)
            .finalHpPokemon1(50)
            .finalHpPokemon2(0)
            .winner(player1)
            .build();

        BattleResult battleResult7 = BattleResult.builder()
            .id(7)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon3)
            .pokemonPlayer2(pokemon4)
            .finalHpPokemon1(0)
            .finalHpPokemon2(40)
            .winner(player2)
            .build();

        BattleResult battleResult8 = BattleResult.builder()
            .id(8)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon5)
            .pokemonPlayer2(pokemon6)
            .finalHpPokemon1(100)
            .finalHpPokemon2(0)
            .winner(player1)
            .build();

        BattleResult battleResult9 = BattleResult.builder()
            .id(9)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon7)
            .pokemonPlayer2(pokemon8)
            .finalHpPokemon1(0)
            .finalHpPokemon2(120)
            .winner(player2)
            .build();

        BattleResult battleResult10 = BattleResult.builder()
            .id(10)
            .player1(player1)
            .player2(player2)
            .pokemonPlayer1(pokemon9)
            .pokemonPlayer2(pokemon10)
            .finalHpPokemon1(60)
            .finalHpPokemon2(0)
            .winner(player1)
            .build();

        return List.of(battleResult1, battleResult2, battleResult3, battleResult4, battleResult5, battleResult6,
            battleResult7, battleResult8, battleResult9, battleResult10);
    }
}
