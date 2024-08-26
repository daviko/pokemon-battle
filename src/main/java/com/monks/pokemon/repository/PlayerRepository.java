package com.monks.pokemon.repository;

import com.monks.pokemon.entity.Player;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findById(Long id);
}
