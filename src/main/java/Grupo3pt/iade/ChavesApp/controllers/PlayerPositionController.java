package Grupo3pt.iade.ChavesApp.controllers;

import Grupo3pt.iade.ChavesApp.models.PlayerPosition;
import Grupo3pt.iade.ChavesApp.services.PlayerPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PlayerPositionController {

    @Autowired
    private PlayerPositionService playerPositionService;

    @GetMapping
    public List<PlayerPosition> getAllPositions() {
        return playerPositionService.getAllPositions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerPosition> getPositionById(@PathVariable Integer id) {
        return playerPositionService.getPositionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PlayerPosition createPosition(@RequestBody PlayerPosition position) {
        return playerPositionService.createPosition(position);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerPosition> updatePosition(@PathVariable Integer id, @RequestBody PlayerPosition positionDetails) {
        return playerPositionService.getPositionById(id)
                .map(position -> {
                    PlayerPosition updatedPosition = playerPositionService.updatePosition(id, positionDetails);
                    return ResponseEntity.ok(updatedPosition);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable Integer id) {
        if (playerPositionService.getPositionById(id).isPresent()) {
            playerPositionService.deletePosition(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


