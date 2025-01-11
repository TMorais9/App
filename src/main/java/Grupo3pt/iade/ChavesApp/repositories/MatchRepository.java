package Grupo3pt.iade.ChavesApp.repositories;

import Grupo3pt.iade.ChavesApp.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}

    
    
    
