package Grupo3pt.iade.ChavesApp.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Grupo3pt.iade.ChavesApp.models.Team;
import Grupo3pt.iade.ChavesApp.repositories.TeamRepository;

@Service
public class TeamService {
    @Autowired
    private TeamRepository repository;


    public List<Team> getTeams(){
        return repository.findAll();

    }
    public Team addTeam(Team team){
        return repository.save(team);
    }

    public Team findTeamById(int id){
        return repository.findById(id).orElse(null);
    }

    public Team findTeamByName(String name){
        return repository.findByName(name);
    }
    
}
