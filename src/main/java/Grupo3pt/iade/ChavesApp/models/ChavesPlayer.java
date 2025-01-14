package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chavesplayer")
public class ChavesPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chpla_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "chpla_seas_id", nullable = false)
    private Season season;

    @ManyToOne
    @JoinColumn(name = "chpla_pla_id", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "chpla_pos_id", nullable = false)
    private Position position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
