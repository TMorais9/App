package Grupo3pt.iade.ChavesApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository<Match> extends JpaRepository<Match, Long> {
    
}
   
    
    
    
