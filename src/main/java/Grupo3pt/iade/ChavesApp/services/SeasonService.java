package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.Season;
import Grupo3pt.iade.ChavesApp.repositories.SeasonRepository;
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

    
    public Season updateSeason(Long id, Season seasonDetails) {
        return seasonRepository.findById(id)
            .map(season -> {
                season.setName(seasonDetails.getName());
                season.setYear(seasonDetails.getYear());
                return seasonRepository.save(season);
            })
            .orElseThrow(() -> new RuntimeException("Season not found with id " + id));
    }

    
    public void deleteSeason(Long id) {
        if (seasonRepository.existsById(id)) {
            seasonRepository.deleteById(id);
        } else {
            throw new RuntimeException("Season not found with id " + id);
        }
    }
}
