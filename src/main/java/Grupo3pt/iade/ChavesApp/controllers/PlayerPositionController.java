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
    private PlayerPositionService positionService;

    @GetMapping
    public List<PlayerPosition> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerPosition> getPositionById(@PathVariable Integer id) {
        return positionService.getPositionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PlayerPosition createPosition(@RequestBody PlayerPosition position) {
        return positionService.createPosition(position);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerPosition> updatePosition(@PathVariable Integer id, @RequestBody PlayerPosition positionDetails) {
        return positionService.getPositionById(id)
                .map(position -> {
                    PlayerPosition updatedPosition = positionService.updatePosition(id, positionDetails);
                    return ResponseEntity.ok(updatedPosition);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable Integer id) {
        if (positionService.getPositionById(id).isPresent()) {
            positionService.deletePosition(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}



