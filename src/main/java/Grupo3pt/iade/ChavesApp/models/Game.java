package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer id;

    @Column(name = "game_name", nullable = false, length = 60)
    private String name;

    @Column(name = "game_dt", nullable = false)
    private Date date;

    @Column(name = "game_sta_id", nullable = false)
    private Integer stadiumId;

    @Column(name = "game_comp_id", nullable = false)
    private Integer competitionId;

    @Column(name = "game_opp_id", nullable = false)
    private Integer opponentId;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Integer stadiumId) {
        this.stadiumId = stadiumId;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(Integer opponentId) {
        this.opponentId = opponentId;
    }
}


