package Grupo3pt.iade.ChavesApp.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Grupo3pt.iade.ChavesApp.models.Match;
import Grupo3pt.iade.ChavesApp.services.MatchService;







@RestController
@RequestMapping("/api")

public class MatchController {
    @Autowired
    private MatchService serviceMatch;


    @GetMapping("/matchById/{id}")
    public Match teamId(@PathVariable Integer id) {
        return serviceMatch.findMatchById(id);
    }

    

    
}
