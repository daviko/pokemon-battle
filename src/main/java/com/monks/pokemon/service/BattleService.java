package com.monks.pokemon.service;

import com.monks.pokemon.model.BattleRequest;
import com.monks.pokemon.model.BattleResult;
import com.monks.pokemon.model.Player;
import com.monks.pokemon.model.Pokemon;
import com.monks.pokemon.repository.BattleResultRepository;
import com.monks.pokemon.repository.PokemonRepository;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    private final BattleResultRepository battleResultRepository;
    private final PokemonRepository pokemonRepository;
    private List<Pokemon> pokemonsToSelect;
    private final Random random;

    @Autowired
    public BattleService(BattleResultRepository battleResultRepository, PokemonRepository pokemonRepository) {
        this.battleResultRepository = battleResultRepository;
        this.pokemonRepository = pokemonRepository;
        pokemonsToSelect = this.pokemonRepository.getPokemons();
        random = new Random();
    }

    public Optional<BattleResult> getBattleResultById(Integer id) {
        return battleResultRepository.getBattleResultById(id);
    }

    public List<BattleResult> getAllBattleResults() {
        return battleResultRepository.getBattleResults();
    }

    public BattleResult addBattleResult(BattleResult battleResult) {
        return battleResultRepository.addBattleResult(battleResult);
    }

    public BattleResult updateBattleResult(Integer id, BattleResult battleResult) {
        return battleResultRepository.updateBattleResult(id, battleResult);
    }

    public boolean removeBattleResult(Integer id) {
        return battleResultRepository.removeBattleResult(id);
    }

    public BattleResult prepareBattle(BattleRequest battleRequest) {
        Player winner = battleRequest.getPlayer1();

        // Select Pokémon for both players
        Pokemon pokemonPlayer1 = getRandomPokemon("");
        Pokemon pokemonPlayer2 = getRandomPokemon(pokemonPlayer1.getId());

        // Preserve initial HP for later use
        Integer initialHpPokemon1 = pokemonPlayer1.getHp();
        Integer initialHpPokemon2 = pokemonPlayer2.getHp();

        while (pokemonPlayer1.getHp() > 0 && pokemonPlayer2.getHp() > 0) {
            startBattle(pokemonPlayer1, pokemonPlayer2);

            if (pokemonPlayer2.getHp() > 0) {
                startBattle(pokemonPlayer2, pokemonPlayer1);

                if (pokemonPlayer1.getHp() <= 0) {
                    winner = battleRequest.getPlayer2();
                }
            }
        }

        // Get final HP values
        Integer finalHpPokemon1 = Math.max(pokemonPlayer1.getHp(), 0);
        Integer finalHpPokemon2 = Math.max(pokemonPlayer2.getHp(), 0);

        // Reset HP to initial values
        pokemonPlayer1.setHp(initialHpPokemon1);
        pokemonPlayer2.setHp(initialHpPokemon2);

        // Build and save the battle result
        BattleResult battleResult = BattleResult.builder()
            .player1(battleRequest.getPlayer1())
            .player2(battleRequest.getPlayer2())
            .pokemonPlayer1(pokemonPlayer1)
            .pokemonPlayer2(pokemonPlayer2)
            .finalHpPokemon1(finalHpPokemon1)
            .finalHpPokemon2(finalHpPokemon2)
            .winner(winner)
            .build();

        return battleResultRepository.addBattleResult(battleResult);
    }

    private Pokemon getRandomPokemon(String idPokemonToSkip) {
        return pokemonsToSelect.stream()
            .filter(pokemon -> !pokemon.getId().equals(idPokemonToSkip))
            .skip(random.nextInt(pokemonsToSelect.size() - 1))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No available Pokemon to select."));
    }

    private void startBattle(Pokemon attacker, Pokemon defender) {
        int damage = attacker.getAttack().getDamage();
        defender.setHp(defender.getHp() - damage);
    }

}
