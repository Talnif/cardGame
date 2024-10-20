/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author aadit
 */
public class PlayingCard extends Card {
    private String suit; 
    private String rank; 
    public PlayingCard(String suit, String rank){
        this.suit = suit; 
        this.rank = rank;
    }
    
    public String getSUit(){
        return suit; 
    }
    
    public String getRank(){
        return rank;
    }
    
    @Override 
    public String toString(){
        return rank + " of" + suit;
    }
    
}
