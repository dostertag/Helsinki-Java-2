


public class Card implements Comparable<Card> {

    /*
     * These are static constant variables. These variables can be used inside and outside
     * of this class like, for example, Card.CLUBS
     */
    public static final int SPADES = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS = 3;
    /*
     * To make printing easier, Card-class also has string arrays for suits and values.
     * SUITS[suit] is a string representation of the suit (Clubs, Diamonds, Hearts, Spades)
     * VALUES[value] is an abbreviation of the card's value (A, J, Q, K, [2..10]).
     */
    public static final String[] SUITS = {"Spades", "Diamonds", "Hearts", "Clubs"};
    public static final String[] VALUES = {"-", "-", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return VALUES[value] + " of " + SUITS[suit];
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }
    
    @Override
    public int compareTo(Card card) {
        
        if (this.value == card.value) {
            return this.suit - card.suit;
        } else {
            return this.value - card.value;
        }
        /*
        if (this.value - card.value !=0){
            return this.value - card.value;
        } else {
            return this.suit - card.suit;
        }
        */
    }

}


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<Card>();
    }
    public void add(Card card) {
        this.cards.add(card);
    }
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }
    private int totalValue() {
        int totalValue = 0;
        for (Card card : this.cards) {
            totalValue += card.getValue();
        }
        return totalValue;
    }
    @Override
    public int compareTo(Hand hand) {
        return this.totalValue() - hand.totalValue();
    }
    public void sort(){
        Collections.sort(this.cards);
    }
    public void sortAgainstSuit(){
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }
}

import java.util.Comparator;


public class SortAgainstSuitAndValue implements Comparator<Card>{
    
    @Override
    public int compare(Card card1, Card card2) {
        if (card1.getSuit() == card2.getSuit()) {
            return card1.getValue() - card2.getValue();
        } else {
            return card1.getSuit() - card2.getSuit();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // write some test code here
        Hand hand = new Hand();

        hand.add( new Card(12, Card.HEARTS) );
        hand.add( new Card(4, Card.CLUBS) );
        hand.add( new Card(2, Card.DIAMONDS) );
        hand.add( new Card(14, Card.CLUBS) );
        hand.add( new Card(7, Card.HEARTS) );
        hand.add( new Card(2, Card.CLUBS) );

        hand.sortAgainstSuit();

        hand.print();
    }
}
