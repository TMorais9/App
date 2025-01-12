package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.OpponentTeam;
import Grupo3pt.iade.ChavesApp.models.PlayerPosition;
import Grupo3pt.iade.ChavesApp.repositories.OpponentTeamRepository;
import Grupo3pt.iade.ChavesApp.repositories.PlayerPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpponentTeamService {

    @Autowired
    private OpponentTeamRepository opponentTeamRepository;

    @Autowired
    private PlayerPositionRepository positionRepository;

    public List<OpponentTeam> getAllOpponentTeams() {
        return opponentTeamRepository.findAll();
    }

    public Optional<OpponentTeam> getOpponentTeamById(Long id) {
        return opponentTeamRepository.findById(id);
    }

    public OpponentTeam createOpponentTeam(OpponentTeam team) {
        team.getPlayers().forEach(player -> {
            Integer positionId = player.getPosition().getPos_id();
            PlayerPosition position = positionRepository.findById(positionId)
                    .orElseThrow(() -> new RuntimeException("Position not found with id " + positionId));
            player.setPosition(position);
        });
        return opponentTeamRepository.save(team);
    }

    public Optional<OpponentTeam> updateOpponentTeam(Long id, OpponentTeam teamDetails) {
        return opponentTeamRepository.findById(id).map(existingTeam -> {
            existingTeam.setName(teamDetails.getName());
            existingTeam.setPlayers(teamDetails.getPlayers());
            return opponentTeamRepository.save(existingTeam);
        });
    }

    public boolean deleteOpponentTeam(Long id) {
        if (opponentTeamRepository.existsById(id)) {
            opponentTeamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
