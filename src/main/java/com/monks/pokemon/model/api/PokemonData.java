package com.monks.pokemon.model.api;

import java.util.List;
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
public class PokemonData {

    private String id;
    private String name;
    private String supertype;
    private List<String> subtypes;
    private String level;
    private String hp;
    private List<String> types;
    private List<String> evolvesTo;
    private List<String> rules;
    private String evolvesFrom;
    private List<Ability> abilities;
    private List<Attack> attacks;
    private List<Weakness> weaknesses;
    private List<String> retreatCost;
    private Integer convertedRetreatCost;
    private List<Resistance> resistances;
    private Set set;
    private String number;
    private String artist;
    private String flavorText;
    private String rarity;
    private List<Integer> nationalPokedexNumbers;
    private Legalities legalities;
    private String regulationMark;
    private Images images;
    private TCGPlayer tcgplayer;
    private CardMarket cardmarket;
}
