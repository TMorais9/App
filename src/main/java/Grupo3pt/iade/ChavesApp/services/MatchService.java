package Grupo3pt.iade.ChavesApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Grupo3pt.iade.ChavesApp.models.Match;
import Grupo3pt.iade.ChavesApp.repositories.MatchRepository;

@Service
public class MatchService {
    @Autowired
    private MatchRepository repository;

    public Match findMatchById(int id){
        return repository.findById(id).orElse(null);
    }
    
    

    

   
}
