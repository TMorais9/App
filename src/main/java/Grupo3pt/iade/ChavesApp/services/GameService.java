package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.Game;
import Grupo3pt.iade.ChavesApp.models.Team;
import Grupo3pt.iade.ChavesApp.models.OpponentTeam;
import Grupo3pt.iade.ChavesApp.repositories.GameRepository;
import Grupo3pt.iade.ChavesApp.repositories.TeamRepository;
import Grupo3pt.iade.ChavesApp.repositories.OpponentTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private OpponentTeamRepository opponentTeamRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Game createGame(Game game) {
        Long teamId = game.getTeam().getId();
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with id " + teamId));
        game.setTeam(team);

        Long opponentTeamId = game.getOpponentTeam().getId();
        OpponentTeam opponentTeam = opponentTeamRepository.findById(opponentTeamId)
                .orElseThrow(() -> new RuntimeException("OpponentTeam not found with id " + opponentTeamId));
        game.setOpponentTeam(opponentTeam);

        return gameRepository.save(game);
    }

    public Game updateGame(Long id, Game gameDetails) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setName(gameDetails.getName());
                    game.setDate(gameDetails.getDate());

                    Long teamId = gameDetails.getTeam().getId();
                    Team team = teamRepository.findById(teamId)
                            .orElseThrow(() -> new RuntimeException("Team not found with id " + teamId));
                    game.setTeam(team);

                    Long opponentTeamId = gameDetails.getOpponentTeam().getId();
                    OpponentTeam opponentTeam = opponentTeamRepository.findById(opponentTeamId)
                            .orElseThrow(() -> new RuntimeException("OpponentTeam not found with id " + opponentTeamId));
                    game.setOpponentTeam(opponentTeam);

                    return gameRepository.save(game);
                })
                .orElseThrow(() -> new RuntimeException("Game not found with id " + id));
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}



