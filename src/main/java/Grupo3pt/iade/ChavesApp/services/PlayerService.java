package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.Player;
import Grupo3pt.iade.ChavesApp.models.PlayerPosition;
import Grupo3pt.iade.ChavesApp.repositories.PlayerRepository;
import Grupo3pt.iade.ChavesApp.repositories.PlayerPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerPositionRepository positionRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    public Player createPlayer(Player player) {
        Integer positionId = player.getPosition().getPos_id();
        PlayerPosition position = positionRepository.findById(positionId)
                .orElseThrow(() -> new RuntimeException("Position not found with id " + positionId));
        player.setPosition(position);
        return playerRepository.save(player);
    }

    public Player updatePlayer(Integer id, Player playerDetails) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(playerDetails.getName());
                    player.setBirthDate(playerDetails.getBirthDate());
                    player.setYears(playerDetails.getYears());
                    player.setNumber(playerDetails.getNumber());
                    player.setNationality(playerDetails.getNationality());
                    player.setPhoto(playerDetails.getPhoto());
                    Integer positionId = playerDetails.getPosition().getPos_id();
                    PlayerPosition position = positionRepository.findById(positionId)
                            .orElseThrow(() -> new RuntimeException("Position not found with id " + positionId));
                    player.setPosition(position);
                    return playerRepository.save(player);
                })
                .orElseThrow(() -> new RuntimeException("Player not found with id " + id));
    }

    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }
}

