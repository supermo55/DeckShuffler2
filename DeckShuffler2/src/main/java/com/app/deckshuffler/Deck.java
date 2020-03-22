package com.app.deckshuffler;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Deck {
    @Id
    @GeneratedValue
    private Long id;

    String name;
  transient ArrayList<Card> deck;

  /** generate a deck of cards using a double nested for loop to add suit and rank
   * to a card and add that card to the list of cards for the deck **/
    public ArrayList<Card> generateDeck()
    {
        ArrayList<Card> deck = new ArrayList<Card>();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(s,r));
            }
        }
        return deck;
    }

    /** return the deck **/
    public ArrayList<Card> getDeck() {
        return deck;
    }
    /** set the arraylist of cards to the arraylsit of cards in deck **/
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** Default Constructor **/
    public Deck()
    {
        this.deck=generateDeck();
    }
    /** Constructor with  name parameter **/
    public Deck(String name) {
        this.deck = generateDeck();
        this.name = name;
    }
}

