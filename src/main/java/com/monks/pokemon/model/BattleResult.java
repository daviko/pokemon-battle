package com.monks.pokemon.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BattleResult {

    private Integer id;

    @NotNull
    private Player player1;

    @NotNull
    private Player player2;

    @NotNull
    private Pokemon pokemonPlayer1;

    @NotNull
    private Pokemon pokemonPlayer2;

    @NotNull
    private Integer finalHpPokemon1;

    @NotNull
    private Integer finalHpPokemon2;

    @NotNull
    private Player winner;
}
