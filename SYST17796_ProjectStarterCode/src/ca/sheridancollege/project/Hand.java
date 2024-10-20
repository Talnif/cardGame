/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author aadit
 */
public class Hand extends GroupOfCards{
    
   public Hand(int maxSize) {
        super(maxSize);
    }

    // Add a card to the hand
    public void addCardHand(Card card) {
        addCard(card);
    }

    // Play a card at a specific index
    public Card playCard(int index) {
        if (index >= 0 && index < getCards().size()) {
            return getCards().remove(index); // Remove the card at the specified index and return it
        } else {
            return null; // Return null if the index is out of bounds
        }
    }

    public boolean isEmpty() {
        return getCards().isEmpty();
    }
}
