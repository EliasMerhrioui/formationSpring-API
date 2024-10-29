package com.postgresql.formationSpring.repository;

import com.postgresql.formationSpring.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}