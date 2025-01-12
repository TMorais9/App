package Grupo3pt.iade.ChavesApp.controllers;

import Grupo3pt.iade.ChavesApp.models.OpponentTeam;
import Grupo3pt.iade.ChavesApp.services.OpponentTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opponent-teams")
public class OpponentTeamController {

    @Autowired
    private OpponentTeamService opponentTeamService;

    @GetMapping
    public List<OpponentTeam> getAllOpponentTeams() {
        return opponentTeamService.getAllOpponentTeams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpponentTeam> getOpponentTeamById(@PathVariable Long id) {
        return opponentTeamService.getOpponentTeamById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OpponentTeam createOpponentTeam(@RequestBody OpponentTeam team) {
        return opponentTeamService.createOpponentTeam(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpponentTeam> updateOpponentTeam(@PathVariable Long id, @RequestBody OpponentTeam teamDetails) {
        return opponentTeamService.updateOpponentTeam(id, teamDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpponentTeam(@PathVariable Long id) {
        if (opponentTeamService.deleteOpponentTeam(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
