package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class PlayerPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pos_id")
    private Integer pos_id;

    @Column(name = "pos_name", nullable = false, length = 60)
    private String pos_name;

    // Getters e Setters
    public Integer getPos_id() {
        return pos_id;
    }

    public void setPos_id(Integer pos_id) {
        this.pos_id = pos_id;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }
}


