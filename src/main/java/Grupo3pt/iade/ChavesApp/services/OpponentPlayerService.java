package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.OpponentPlayer;
import Grupo3pt.iade.ChavesApp.repositories.OpponentPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpponentPlayerService {

    @Autowired
    private OpponentPlayerRepository opponentPlayerRepository;

    public List<OpponentPlayer> getAllOpponentPlayers() {
        return opponentPlayerRepository.findAll();
    }

    public Optional<OpponentPlayer> getOpponentPlayerById(Integer id) {
        return opponentPlayerRepository.findById(id);
    }

    public OpponentPlayer createOpponentPlayer(OpponentPlayer opponentPlayer) {
        return opponentPlayerRepository.save(opponentPlayer);
    }

    public OpponentPlayer updateOpponentPlayer(Integer id, OpponentPlayer opponentPlayerDetails) {
        return opponentPlayerRepository.findById(id)
            .map(opponentPlayer -> {
                opponentPlayer.setOppla_pla_id(opponentPlayerDetails.getOppla_pla_id());
                opponentPlayer.setOppla_opp_id(opponentPlayerDetails.getOppla_opp_id());
                opponentPlayer.setOppla_pos_id(opponentPlayerDetails.getOppla_pos_id());
                opponentPlayer.setOppla_seas_id(opponentPlayerDetails.getOppla_seas_id());
                return opponentPlayerRepository.save(opponentPlayer);
            })
            .orElseThrow(() -> new RuntimeException("Opponent Player not found with id " + id));
    }

    public void deleteOpponentPlayer(Integer id) {
        opponentPlayerRepository.deleteById(id);
    }
}

