/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;


/**
 *
 * @author aadit
 */
public class CardGame {
    
    private Hand playerHand;
    private Hand computerHand;
    private Deck deck;
    private int playerScore;
    private int computerScore;

    public CardGame() {
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand(5);
        computerHand = new Hand(5);
        dealCards();
    }

    // Method to deal cards to both player and computer
    private void dealCards() {
        for (int i = 0; i < 5; i++) {
            playerHand.addCardHand(deck.drawCard());
            computerHand.addCardHand(deck.drawCard());
        }
    }

    // Method to start the game
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (!playerHand.isEmpty() && !computerHand.isEmpty()) {
            System.out.println("\nYour hand: " + playerHand.getCards());
            System.out.println("Computer's hand has " + computerHand.getCards().size() + " cards.");

            System.out.print("Choose a card index to play (0 to " + (playerHand.getCards().size() - 1) + "): ");
            int cardIndex = scanner.nextInt();
            Card playedCard = playerHand.playCard(cardIndex);
            Card computerCard = computerHand.playCard(0);

            System.out.println("You played: " + playedCard);
            System.out.println("Computer played: " + computerCard);

            // Compare cards and determine the winner of the round
            int result = compareCards(playedCard, computerCard);
            if (result > 0) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (result < 0) {
                System.out.println("Computer wins this round!");
                computerScore++;
            } else {
                System.out.println("It's a tie for this round!");
            }

            System.out.println("Your score: " + playerScore + ", Computer's score: " + computerScore);
        }

        // Determine the final winner
        declareWinner();
    }

    // Compares two cards
    private static int compareCards(Card card1, Card card2) {
        int rank1 = getCardRank(card1);
        int rank2 = getCardRank(card2);

        if (rank1 > rank2) {
            return 1; // card1 is greater
        } else if (rank1 < rank2) {
            return -1; // card2 is greater
        } else {
            return 0; // they are equal
        }
    }

    // Gets the rank of a card
    private static int getCardRank(Card card) {
        String rank = card.toString().split(" ")[0]; // Assuming the format is "rank ofSuit"
        switch (rank) {
            case "Ace":
                return 14; // Highest rank
            case "King":
                return 13;
            case "Queen":
                return 12;
            case "Jack":
                return 11;
            default:
                return Integer.parseInt(rank); // For numbered cards
        }
    }

    // Declare the winner based on scores
    private void declareWinner() {
        System.out.println("\nFinal Scores:");
        System.out.println("Your score: " + playerScore);
        System.out.println("Computer's score: " + computerScore);
        
        if (playerScore > computerScore) {
            System.out.println("You win the game!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins the game!");
        } else {
            System.out.println("It's a tie overall!");
        }
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.start();
    }
}


