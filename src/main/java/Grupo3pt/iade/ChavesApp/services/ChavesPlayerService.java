package Grupo3pt.iade.ChavesApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Grupo3pt.iade.ChavesApp.models.ChavesPlayer;
import Grupo3pt.iade.ChavesApp.repositories.ChavesPlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChavesPlayerService {

    @Autowired
    private ChavesPlayerRepository playerRepository;

    public List<ChavesPlayer> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<ChavesPlayer> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public ChavesPlayer createPlayer(ChavesPlayer player) {
        return playerRepository.save(player);
    }

    public ChavesPlayer updatePlayer(Long id, ChavesPlayer playerDetails) {
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
