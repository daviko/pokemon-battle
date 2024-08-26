package com.monks.pokemon.model.api;

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
public class Holofoil {

    private double low;
    private double mid;
    private double high;
    private double market;
    private Object directLow;
}
