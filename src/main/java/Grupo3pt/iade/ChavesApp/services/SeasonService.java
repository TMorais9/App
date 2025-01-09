import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    public Optional<Season> getSeasonById(Long id) {
        return seasonRepository.findById(id);
    }

    public Season createSeason(Season season) {
        return seasonRepository.save(season);
    }

    public Optional<Season> updateSeason(Long id, Season seasonDetails) {
        return seasonRepository.findById(id).map(season -> {
            season.setName(seasonDetails.getName());
            season.setStartDate(seasonDetails.getStartDate());
            season.setEndDate(seasonDetails.getEndDate());
            return seasonRepository.save(season);
        });
    }

    public boolean deleteSeason(Long id) {
        if (seasonRepository.existsById(id)) {
            seasonRepository.deleteById(id);
            return true;
        }
        return false;
    }
}