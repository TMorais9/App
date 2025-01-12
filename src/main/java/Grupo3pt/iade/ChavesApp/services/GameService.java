package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.Game;
import Grupo3pt.iade.ChavesApp.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Integer id) {
        return gameRepository.findById(id);
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Game updateGame(Integer id, Game gameDetails) {
        return gameRepository.findById(id)
            .map(game -> {
                game.setName(gameDetails.getName());
                game.setDate(gameDetails.getDate());
                game.setStadiumId(gameDetails.getStadiumId());
                game.setCompetitionId(gameDetails.getCompetitionId());
                game.setOpponentId(gameDetails.getOpponentId());
                return gameRepository.save(game);
            })
            .orElseThrow(() -> new RuntimeException("Game not found with id " + id));
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }
}


