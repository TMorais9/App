package Grupo3pt.iade.ChavesApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Grupo3pt.iade.ChavesApp.models.Team;
import Grupo3pt.iade.ChavesApp.services.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")

public class TeamController {
    @Autowired
    private TeamService serviceTeams;

    @GetMapping("/teams")
    public List<Team> getTeams(){
        return serviceTeams.getTeams();
    }

    @PostMapping("/insertTeam")
    public Team addTeam(@RequestBody Team team) {
        return serviceTeams.addTeam(team);
    }
    @GetMapping("/teamById/{id}")
    public Team teamId(@PathVariable Integer id) {
        return serviceTeams.findTeamById(id);
    }
    @GetMapping("/teamByName/{name}")
    public Team getName(@PathVariable String name) {
        return serviceTeams.findTeamByName(name);
    }
    
}
