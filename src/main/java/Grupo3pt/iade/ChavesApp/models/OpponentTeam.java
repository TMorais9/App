package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "opponent_team")
public class OpponentTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "opponent_team_id")
    private List<OpponentPlayer> players;

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

    public List<OpponentPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<OpponentPlayer> players) {
        this.players = players;
    }
}

