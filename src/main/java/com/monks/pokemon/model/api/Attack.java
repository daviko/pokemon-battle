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
public class Attack {

    private List<String> cost;
    private String name;
    private String text;
    private String damage;
    private int convertedEnergyCost;
}
