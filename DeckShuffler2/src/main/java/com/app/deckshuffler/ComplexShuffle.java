package com.app.deckshuffler;

import java.util.ArrayList;
import java.util.Collections;

public class ComplexShuffle implements Shuffler {


    public Deck shuffle(Deck d) {

        int repeatRandom =(int)(Math.random() *7)+1;
        for(int i=0; i<repeatRandom; i++)
        {
            d=(complexShuffle(d));
        }
        return d;
    }

    public Deck complexShuffle(Deck d) {
/** generate a random split location in the deck **/
        int randoSplit = (int) (Math.random() * 51) +1;
        int split = randoSplit;

        ArrayList<Card> firstHalf = new ArrayList<Card>(d.getDeck().subList(0, split));
        ArrayList<Card> secondHalf = new ArrayList<Card>(d.getDeck()
                .subList(split, d.getDeck().size()));
/** shuffle each half and then combine them and shuffle again**/
        Collections.shuffle(firstHalf);
        Collections.shuffle(secondHalf);

        ArrayList<Card> finalDeck = new ArrayList<Card>();
        finalDeck.addAll(firstHalf);
        finalDeck.addAll(secondHalf);
        Collections.shuffle(finalDeck);
        /** assign the array of cards to the array of cards in d **/
        d.setDeck(finalDeck);
        return d;
    }
}

