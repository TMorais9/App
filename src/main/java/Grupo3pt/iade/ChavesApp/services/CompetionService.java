package Grupo3pt.iade.ChavesApp.services;

import Grupo3pt.iade.ChavesApp.models.Competition;
import Grupo3pt.iade.ChavesApp.models.Team;
import Grupo3pt.iade.ChavesApp.models.OpponentTeam;
import Grupo3pt.iade.ChavesApp.repositories.CompetitionRepository;
import Grupo3pt.iade.ChavesApp.repositories.TeamRepository;
import Grupo3pt.iade.ChavesApp.repositories.OpponentTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private OpponentTeamRepository opponentTeamRepository;

    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public Optional<Competition> getCompetitionById(Integer id) {
        return competitionRepository.findById(id);
    }

    public Competition createCompetition(Competition competition) {
        Long teamId = competition.getTeam().getId();
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with id " + teamId));
        competition.setTeam(team);

        competition.getOpponentTeams().forEach(opponentTeam -> {
            Long opponentTeamId = opponentTeam.getId();
            OpponentTeam existingOpponentTeam = opponentTeamRepository.findById(opponentTeamId)
                    .orElseThrow(() -> new RuntimeException("OpponentTeam not found with id " + opponentTeamId));
            opponentTeam.setName(existingOpponentTeam.getName());
        });

        return competitionRepository.save(competition);
    }

    public Competition updateCompetition(Integer id, Competition competitionDetails) {
        return competitionRepository.findById(id)
                .map(existingCompetition -> {
                    existingCompetition.setName(competitionDetails.getName());

                    Long teamId = competitionDetails.getTeam().getId();
                    Team team = teamRepository.findById(teamId)
                            .orElseThrow(() -> new RuntimeException("Team not found with id " + teamId));
                    existingCompetition.setTeam(team);

                    existingCompetition.setOpponentTeams(competitionDetails.getOpponentTeams());
                    return competitionRepository.save(existingCompetition);
                })
                .orElseThrow(() -> new RuntimeException("Competition not found with id " + id));
    }

    public void deleteCompetition(Integer id) {
        competitionRepository.deleteById(id);
    }
}
