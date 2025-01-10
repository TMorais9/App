package Grupo3pt.iade.ChavesApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Grupo3pt.iade.ChavesApp.models.Player;
import Grupo3pt.iade.ChavesApp.repositories.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player playerDetails) {
        return playerRepository.findById(id)
            .map(player -> {
                player.setPla_name(playerDetails.getPla_name());
                player.setBirthDate(playerDetails.getBirthDate());
                player.setYears(playerDetails.getYears());
                player.setNumber(playerDetails.getNumber());
                player.setNationality(playerDetails.getNationality());
                player.setPhoto(playerDetails.getPhoto());
                return playerRepository.save(player);
            })
            .orElseThrow(() -> new RuntimeException("Player not found with id " + id));
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
