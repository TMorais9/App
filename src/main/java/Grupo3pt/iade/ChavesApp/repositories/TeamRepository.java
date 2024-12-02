package Grupo3pt.iade.ChavesApp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import Grupo3pt.iade.ChavesApp.models.Team;



public interface TeamRepository extends JpaRepository<Team, Integer> {
   
    Team findByName(String name);
    
    
}
