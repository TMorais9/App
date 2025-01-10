package Grupo3pt.iade.ChavesApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Grupo3pt.iade.ChavesApp.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
