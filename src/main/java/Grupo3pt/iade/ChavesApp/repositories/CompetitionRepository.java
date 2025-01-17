package Grupo3pt.iade.ChavesApp.repositories;

import Grupo3pt.iade.ChavesApp.models.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
}
