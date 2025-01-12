package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @Column(name = "game_name", nullable = false, length = 60)
    private String name;

    @Column(name = "game_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "game_team_id", nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "game_opponent_team_id", nullable = false)
    private OpponentTeam opponentTeam;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public OpponentTeam getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(OpponentTeam opponentTeam) {
        this.opponentTeam = opponentTeam;
    }
}



