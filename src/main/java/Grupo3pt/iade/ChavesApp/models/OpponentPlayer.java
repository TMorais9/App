package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "opponentplayer")
public class OpponentPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oppla_id;

    @Column(name = "oppla_pla_id", nullable = false)
    private Integer oppla_pla_id;

    @Column(name = "oppla_opp_id", nullable = false)
    private Integer oppla_opp_id;

    @Column(name = "oppla_pos_id", nullable = false)
    private Integer oppla_pos_id;

    @Column(name = "oppla_seas_id", nullable = false)
    private Integer oppla_seas_id;

    
    public Integer getOppla_id() {
        return oppla_id;
    }

    public void setOppla_id(Integer oppla_id) {
        this.oppla_id = oppla_id;
    }

    public Integer getOppla_pla_id() {
        return oppla_pla_id;
    }

    public void setOppla_pla_id(Integer oppla_pla_id) {
        this.oppla_pla_id = oppla_pla_id;
    }

    public Integer getOppla_opp_id() {
        return oppla_opp_id;
    }

    public void setOppla_opp_id(Integer oppla_opp_id) {
        this.oppla_opp_id = oppla_opp_id;
    }

    public Integer getOppla_pos_id() {
        return oppla_pos_id;
    }

    public void setOppla_pos_id(Integer oppla_pos_id) {
        this.oppla_pos_id = oppla_pos_id;
    }

    public Integer getOppla_seas_id() {
        return oppla_seas_id;
    }

    public void setOppla_seas_id(Integer oppla_seas_id) {
        this.oppla_seas_id = oppla_seas_id;
    }
}

