package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.OpponentPlayer;
import Grupo3pt.iade.ChavesApp.models.PlayerPosition;
import Grupo3pt.iade.ChavesApp.repositories.OpponentPlayerRepository;
import Grupo3pt.iade.ChavesApp.repositories.PlayerPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpponentPlayerService {

    @Autowired
    private OpponentPlayerRepository opponentPlayerRepository;

    @Autowired
    private PlayerPositionRepository positionRepository;

    public List<OpponentPlayer> getAllOpponentPlayers() {
        return opponentPlayerRepository.findAll();
    }

    public Optional<OpponentPlayer> getOpponentPlayerById(Integer id) {
        return opponentPlayerRepository.findById(id);
    }

    public OpponentPlayer createOpponentPlayer(OpponentPlayer opponentPlayer) {
        Integer positionId = opponentPlayer.getPosition().getPos_id();
        PlayerPosition position = positionRepository.findById(positionId)
                .orElseThrow(() -> new RuntimeException("Position not found with id " + positionId));
        opponentPlayer.setPosition(position);
        return opponentPlayerRepository.save(opponentPlayer);
    }

    public OpponentPlayer updateOpponentPlayer(Integer id, OpponentPlayer opponentPlayerDetails) {
        return opponentPlayerRepository.findById(id)
                .map(opponentPlayer -> {
                    opponentPlayer.setName(opponentPlayerDetails.getName());
                    opponentPlayer.setBirthDate(opponentPlayerDetails.getBirthDate());
                    opponentPlayer.setYears(opponentPlayerDetails.getYears());
                    opponentPlayer.setNumber(opponentPlayerDetails.getNumber());
                    opponentPlayer.setNationality(opponentPlayerDetails.getNationality());
                    opponentPlayer.setPhoto(opponentPlayerDetails.getPhoto());
                    Integer positionId = opponentPlayerDetails.getPosition().getPos_id();
                    PlayerPosition position = positionRepository.findById(positionId)
                            .orElseThrow(() -> new RuntimeException("Position not found with id " + positionId));
                    opponentPlayer.setPosition(position);
                    return opponentPlayerRepository.save(opponentPlayer);
                })
                .orElseThrow(() -> new RuntimeException("OpponentPlayer not found with id " + id));
    }

    public void deleteOpponentPlayer(Integer id) {
        opponentPlayerRepository.deleteById(id);
    }
}


