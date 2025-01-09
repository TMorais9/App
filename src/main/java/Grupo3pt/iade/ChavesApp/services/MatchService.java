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

    public Optional<Match> updateMatch(Long id, Match matchDetails) {
        return matchRepository.findById(id).map(match -> {
            match.setDate(matchDetails.getDate());
            match.setPlayer1(matchDetails.getPlayer1());
            match.setPlayer2(matchDetails.getPlayer2());
            match.setScore(matchDetails.getScore());
            return matchRepository.save(match);
        });
    }

    public boolean deleteMatch(Long id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
