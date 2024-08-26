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
public class Set {

    private String id;
    private String name;
    private String series;
    private int printedTotal;
    private int total;
    private Legalities legalities;
    private String ptcgoCode;
    private String releaseDate;
    private String updatedAt;
    private Images images;
}
