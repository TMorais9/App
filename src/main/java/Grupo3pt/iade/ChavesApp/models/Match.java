package Grupo3pt.iade.ChavesApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matches")


public class Match {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    private Team homeTeam;

    @OneToOne
    private Team awayTeam;

    @Column
    private String matchStadium;

    @Column
    private String matchDate;


    public int getId(){
        return id;
    }

    public Team getHomeTeam(){
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam){
       this.homeTeam= homeTeam;
        
    }

    public Team getAwayTeam(){
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam){
       this.awayTeam= awayTeam;
        
    }
    
    public String getMatchStadium(){
        return homeTeam.getStadium();
    }

    
    public String getMatchDate(){
        return matchDate;
    }
    
    public void setMatchDate(String matchDate){
        this.matchDate= matchDate;
         
     }


   
    
    
         
     



}
    
    

    




