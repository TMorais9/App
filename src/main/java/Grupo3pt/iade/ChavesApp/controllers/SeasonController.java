package Grupo3pt.iade.ChavesApp.controllers;

import Grupo3pt.iade.ChavesApp.models.Season; 
import Grupo3pt.iade.ChavesApp.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seasons")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping
    public List<Season> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable Long id) {
        return seasonService.getSeasonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Season createSeason(@RequestBody Season season) {
        return seasonService.createSeason(season);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Season> updateSeason(@PathVariable Long id, @RequestBody Season seasonDetails) {
        try {
            Season updatedSeason = seasonService.updateSeason(id, seasonDetails);
            return ResponseEntity.ok(updatedSeason);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeason(@PathVariable Long id) {
        seasonService.deleteSeason(id);
        return ResponseEntity.noContent().build();
    }
}




