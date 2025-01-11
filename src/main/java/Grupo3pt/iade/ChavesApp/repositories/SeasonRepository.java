package Grupo3pt.iade.ChavesApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Grupo3pt.iade.ChavesApp.models.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}


