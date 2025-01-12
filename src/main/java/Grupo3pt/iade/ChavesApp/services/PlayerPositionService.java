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
    private PlayerPositionRepository positionRepository;

    public List<PlayerPosition> getAllPositions() {
        return positionRepository.findAll();
    }

    public Optional<PlayerPosition> getPositionById(Integer id) {
        return positionRepository.findById(id);
    }

    public PlayerPosition createPosition(PlayerPosition position) {
        return positionRepository.save(position);
    }

    public PlayerPosition updatePosition(Integer id, PlayerPosition positionDetails) {
        return positionRepository.findById(id)
            .map(position -> {
                position.setPos_name(positionDetails.getPos_name());
                return positionRepository.save(position);
            })
            .orElseThrow(() -> new RuntimeException("Position not found with id " + id));
    }

    public void deletePosition(Integer id) {
        positionRepository.deleteById(id);
    }
}

