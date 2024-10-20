/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author aadit
 */
public class Deck extends GroupOfCards {
    
    public Deck() {
        super(52);
        initializeDeck(); 
        shuffle();
    }
    
    private void initializeDeck(){
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; 
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        for (String suit : suits){
            for (String rank : ranks){ 
                addCard(new PlayingCard(suit, rank));
            }
        }
    }
    
}
