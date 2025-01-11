package Grupo3pt.iade.ChavesApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Grupo3pt.iade.ChavesApp.models.Team;
import Grupo3pt.iade.ChavesApp.repositories.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    
    @Autowired
    private TeamRepository teamRepository;

   
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

 
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }


    public Team createTeam(Team team) {
        return (Team) teamRepository.save(team);
    }

   
    public Optional<Team> updateTeam(Long id, Team teamDetails) {
        return teamRepository.findById(id).map(team -> {
            ((Team) team).setName(teamDetails.getName());
            ((Team) team).setPlayers(teamDetails.getPlayers());
            return teamRepository.save(team);
        });
    }

   
    public boolean deleteTeam(Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


