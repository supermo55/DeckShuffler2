package com.app.deckshuffler;

import java.util.ArrayList;
import java.util.Collections;

public class SimpleShuffle implements Shuffler {


    public Deck shuffle(Deck d) {
        /** create a temporary list of cards and assign it to the specified deck's card list**/
        ArrayList<Card> cards = d.getDeck();
        Collections.shuffle(cards);
        d.setDeck(cards);
        return d;
    }
}
