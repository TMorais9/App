package Grupo3pt.iade.ChavesApp.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String name;

    @Column
    private Integer jerseyNumber;

    
    @ManyToOne
    @JoinColumn(name ="team_id")
    private Team team;
    
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
       this.name = name;
        
    }

    public Integer getJerseyNumber(){
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber){
       this.jerseyNumber = jerseyNumber;
        
    }

}