package Grupo3pt.iade.ChavesApp.controllers;

import Grupo3pt.iade.ChavesApp.models.ChavesPlayer;
import Grupo3pt.iade.ChavesApp.repositories.ChavesPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class ChavesPlayerController {

    @Autowired
    private ChavesPlayerRepository playerRepository;

    @GetMapping
    public List<ChavesPlayer> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChavesPlayer> getPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChavesPlayer createPlayer(@RequestBody ChavesPlayer player) {
        return playerRepository.save(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChavesPlayer> updatePlayer(@PathVariable Long id, @RequestBody ChavesPlayer playerDetails) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setPla_name(playerDetails.getPla_name());
                    player.setBirthDate(playerDetails.getBirthDate());
                    player.setYears(playerDetails.getYears());
                    player.setNumber(playerDetails.getNumber());
                    player.setNationality(playerDetails.getNationality());
                    player.setPhoto(playerDetails.getPhoto());
                    ChavesPlayer updatedPlayer = playerRepository.save(player);
                    return ResponseEntity.ok(updatedPlayer);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}                              
