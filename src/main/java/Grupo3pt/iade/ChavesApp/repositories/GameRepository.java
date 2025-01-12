package Grupo3pt.iade.ChavesApp.repositories;

import Grupo3pt.iade.ChavesApp.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}


    
    
    
