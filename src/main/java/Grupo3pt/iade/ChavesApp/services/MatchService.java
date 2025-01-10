package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.Match;
import Grupo3pt.iade.ChavesApp.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @SuppressWarnings("rawtypes")
    @Autowired
    private MatchRepository matchRepository;

    @SuppressWarnings("unchecked")
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @SuppressWarnings("unchecked")
    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    @SuppressWarnings("unchecked")
    public Match createMatch(Match match) {
        return (Match) matchRepository.save(match);
    }

    @SuppressWarnings("unchecked")
    public Optional<Match> updateMatch(Long id, Match matchDetails) {
        return matchRepository.findById(id).map(match -> {
            ((Match) match).setDate(matchDetails.getDate());
            ((Match) match).setPlayer1(matchDetails.getPlayer1());
            ((Match) match).setPlayer2(matchDetails.getPlayer2());
            ((Match) match).setScore(matchDetails.getScore());
            return matchRepository.save(match);
        });
    }

    @SuppressWarnings("unchecked")
    public boolean deleteMatch(Long id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

