package Grupo3pt.iade.ChavesApp.repositories;

import Grupo3pt.iade.ChavesApp.models.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}
