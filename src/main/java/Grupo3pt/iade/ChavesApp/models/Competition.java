package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private Integer id;

    @Column(name = "comp_name", nullable = false, length = 60)
    private String name;

    @ManyToOne
    @JoinColumn(name = "comp_team_id", nullable = false)
    private Team team;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "comp_id")
    private List<OpponentTeam> opponentTeams;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<OpponentTeam> getOpponentTeams() {
        return opponentTeams;
    }

    public void setOpponentTeams(List<OpponentTeam> opponentTeams) {
        this.opponentTeams = opponentTeams;
    }
}
