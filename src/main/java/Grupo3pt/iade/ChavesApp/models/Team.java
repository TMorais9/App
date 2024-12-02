package Grupo3pt.iade.ChavesApp.models;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String name;

    @Column
    private String stadium;

    @OneToMany(mappedBy ="team")
    private List<Player> players;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
       this.name = name;
        
    }

    public String getStadium(){
        return stadium;
    }

    public void setStadium(String stadium){
       this.stadium = stadium;
        
    }
    public List<Player> getPlayers(){
        return players;
    }

    public void setPlayers(List<Player> players){
       this.players = players;
        
    }
    

}
