package com.monks.pokemon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BATTLE_RESULTS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BattleResult implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "battleResults")
    private Set<Player> players;

    @ManyToMany(mappedBy = "battleResults")
    private Set<Pokemon> pokemons;

    @Column(name = "final_hp_pokemon1")
    private Integer finalHpPokemon1;

    @Column(name = "final_hp_pokemon2")
    private Integer finalHpPokemon2;

    private String winner;
}
