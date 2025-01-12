package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.PlayerPosition;
import Grupo3pt.iade.ChavesApp.repositories.PlayerPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerPositionService {

    @Autowired
    private PlayerPositionRepository playerPositionRepository;

    public List<PlayerPosition> getAllPositions() {
        return playerPositionRepository.findAll();
    }

    public Optional<PlayerPosition> getPositionById(Integer id) {
        return playerPositionRepository.findById(id);
    }

    public PlayerPosition createPosition(PlayerPosition position) {
        return playerPositionRepository.save(position);
    }

    public PlayerPosition updatePosition(Integer id, PlayerPosition positionDetails) {
        return playerPositionRepository.findById(id)
            .map(position -> {
                position.setPos_name(positionDetails.getPos_name());
                return playerPositionRepository.save(position);
            })
            .orElseThrow(() -> new RuntimeException("Position not found with id " + id));
    }

    public void deletePosition(Integer id) {
        playerPositionRepository.deleteById(id);
    }
}
