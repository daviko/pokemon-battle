package com.monks.pokemon.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Prices {

    private Holofoil holofoil;
    private Holofoil normal;
    private Holofoil reverseHolofoil;
    private Holofoil unlimitedHolofoil;

    @JsonProperty("1stEditionHolofoil")
    private Holofoil firstEditionHolofoil;

    private double averageSellPrice;
    private double lowPrice;
    private double trendPrice;
    private double germanProLow;
    private double suggestedPrice;
    private double reverseHoloSell;
    private double reverseHoloLow;
    private double reverseHoloTrend;
    private double lowPriceExPlus;
    private double avg1;
    private double avg7;
    private double avg30;
    private double reverseHoloAvg1;
    private double reverseHoloAvg7;
    private double reverseHoloAvg30;
}
