package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pla_id")
    private Integer id;

    @Column(name = "pla_name", nullable = false, length = 60)
    private String name;

    @Column(name = "pla_bdate", nullable = false)
    private String birthDate;

    @Column(name = "pla_anos", nullable = false, length = 60)
    private String years;

    @Column(name = "pla_num", nullable = false, length = 60)
    private String number;

    @Column(name = "pla_nac", nullable = false, length = 60)
    private String nationality;

    @Column(name = "pla_foto", length = 200)
    private String photo;

    @ManyToOne
    @JoinColumn(name = "pla_pos_id", nullable = false)
    private PlayerPosition position;

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }
}

