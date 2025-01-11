package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.Match;
import Grupo3pt.iade.ChavesApp.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match matchDetails) {
        return matchRepository.findById(id)
            .map(match -> {
                match.setDate(matchDetails.getDate());
                match.setPlayer1(matchDetails.getPlayer1());
                match.setPlayer2(matchDetails.getPlayer2());
                match.setScore(matchDetails.getScore());
                return matchRepository.save(match);
            })
            .orElseThrow(() -> new RuntimeException("Match not found with id " + id));
    }

    public void deleteMatch(Long id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
        } else {
            throw new RuntimeException("Match not found with id " + id);
        }
    }
}

