package com.monks.pokemon.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ATTACK")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Attack implements Serializable {

    @Id
    private Integer id;

    private String name;
    private String text;
    private Integer damage;

    @OneToOne(mappedBy = "attack", cascade = CascadeType.ALL)
    private Pokemon pokemon;
}
