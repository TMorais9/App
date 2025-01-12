package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Chavesplayer")
public class ChavesPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pla_id;

    @Column(name = "pla_name", nullable = false, length = 60)
    private String pla_name;

    @Column(name = "pla_bdate", nullable = false)
    private String pla_bdate;

    @Column(name = "pla_anos", nullable = false, length = 60)
    private String pla_anos;

    @Column(name = "pla_num", nullable = false, length = 60)
    private String pla_num;

    @Column(name = "pla_nac", nullable = false, length = 60)
    private String pla_nac;

    @Column(name = "pla_foto", length = 200)
    private String pla_foto;

    public Integer getPla_id() {
        return pla_id;
    }

    public void setPla_id(Integer pla_id) {
        this.pla_id = pla_id;
    }

    public String getPla_name() {
        return pla_name;
    }

    public void setPla_name(String pla_name) {
        this.pla_name = pla_name;
    }

    public String getPla_bdate() {
        return pla_bdate;
    }

    public void setPla_bdate(String pla_bdate) {
        this.pla_bdate = pla_bdate;
    }

    public String getPla_anos() {
        return pla_anos;
    }

    public void setPla_anos(String pla_anos) {
        this.pla_anos = pla_anos;
    }

    public String getPla_num() {
        return pla_num;
    }

    public void setPla_num(String pla_num) {
        this.pla_num = pla_num;
    }

    public String getPla_nac() {
        return pla_nac;
    }

    public void setPla_nac(String pla_nac) {
        this.pla_nac = pla_nac;
    }

    public String getPla_foto() {
        return pla_foto;
    }

    public void setPla_foto(String pla_foto) {
        this.pla_foto = pla_foto;
    }

    public Object getBirthDate() {
        throw new UnsupportedOperationException("Unimplemented method 'getBirthDate'");
    }

    public Object getYears() {
        throw new UnsupportedOperationException("Unimplemented method 'getYears'");
    }

    public Object getNumber() {
        throw new UnsupportedOperationException("Unimplemented method 'getNumber'");
    }

    public Object getNationality() {
        throw new UnsupportedOperationException("Unimplemented method 'getNationality'");
    }

    public Object getPhoto() {
        throw new UnsupportedOperationException("Unimplemented method 'getPhoto'");
    }

    public void setPhoto(Object photo) {
        throw new UnsupportedOperationException("Unimplemented method 'setPhoto'");
    }

    public void setNationality(Object nationality) {
        throw new UnsupportedOperationException("Unimplemented method 'setNationality'");
    }

    public void setNumber(Object number) {
        throw new UnsupportedOperationException("Unimplemented method 'setNumber'");
    }

    public void setYears(Object years) {       
        throw new UnsupportedOperationException("Unimplemented method 'setYears'");
    }

    public void setBirthDate(Object birthDate) {       
        throw new UnsupportedOperationException("Unimplemented method 'setBirthDate'");
    }
}
