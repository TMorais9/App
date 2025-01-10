package Grupo3pt.iade.ChavesApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Grupo3pt.iade.ChavesApp.models.Team;
import Grupo3pt.iade.ChavesApp.repositories.TeamRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @SuppressWarnings("rawtypes")
    @Autowired
    private TeamRepository teamRepository;

    @SuppressWarnings("unchecked")
    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        @SuppressWarnings("unchecked")
        Optional<Team> team = teamRepository.findById(id);
        return team.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @SuppressWarnings("unchecked")
    @PostMapping
    public Object createTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @SuppressWarnings("unchecked")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTeam(@PathVariable Long id, @RequestBody Team teamDetails) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            team.setName(teamDetails.getName());
            team.setPlayers(teamDetails.getPlayers());
            return ResponseEntity.ok(teamRepository.save(team));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @SuppressWarnings("unchecked")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

