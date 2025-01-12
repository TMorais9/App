package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChavesPlayer> players;

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

    public List<ChavesPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<ChavesPlayer> players) {
        this.players = players;
    }
}
