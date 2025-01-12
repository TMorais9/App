package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.PlayerPosition;
import Grupo3pt.iade.ChavesApp.models.Team;
import Grupo3pt.iade.ChavesApp.repositories.TeamRepository;
import Grupo3pt.iade.ChavesApp.repositories.PlayerPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerPositionRepository positionRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team createTeam(Team team) {
        team.getPlayers().forEach(player -> {
            Integer positionId = player.getPosition().getPos_id();
            PlayerPosition position = positionRepository.findById(positionId)
                    .orElseThrow(() -> new RuntimeException("Position not found with id " + positionId));
            player.setPosition(position);
        });
        return teamRepository.save(team);
    }

    public Optional<Team> updateTeam(Long id, Team teamDetails) {
        return teamRepository.findById(id).map(existingTeam -> {
            existingTeam.setName(teamDetails.getName());
            existingTeam.setPlayers(teamDetails.getPlayers());
            return teamRepository.save(existingTeam);
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



