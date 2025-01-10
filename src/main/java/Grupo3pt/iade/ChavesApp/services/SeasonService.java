package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.Session;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {

    @SuppressWarnings("rawtypes")
    @Autowired
    private SeasonRepository seasonRepository;

    @SuppressWarnings("unchecked")
    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    @SuppressWarnings("unchecked")
    public Optional<Season> getSeasonById(Long id) {
        return seasonRepository.findById(id);
    }

    @SuppressWarnings("unchecked")
    public Grupo3pt.iade.ChavesApp.controllers.Season createSeason(Season season) {
        return (Grupo3pt.iade.ChavesApp.controllers.Season) seasonRepository.save(season);
    }

    @SuppressWarnings("unchecked")
    public Grupo3pt.iade.ChavesApp.controllers.Season updateSeason(Long id, Season seasonDetails) {
        return (Grupo3pt.iade.ChavesApp.controllers.Season) seasonRepository.findById(id)
            .map(season -> {
                season.setName(seasonDetails.getName());
                season.setYear(seasonDetails.getYear());
                return seasonRepository.save(season);
            })
            .orElseThrow(() -> new RuntimeException("Season not found with id " + id));
    }

    @SuppressWarnings("unchecked")
    public Grupo3pt.iade.ChavesApp.controllers.Season deleteSeason(Long id) {
        seasonRepository.deleteById(id);
    }
}