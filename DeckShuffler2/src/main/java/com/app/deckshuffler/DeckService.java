package com.app.deckshuffler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeckService {
    @Autowired
    DeckRepository dr;
    @Autowired
    Shuffler shuff;

    /** create a deck with the specified name and save it to the repository and return the created deck **/
    public Deck createDeck(String name)
 {
     Deck d =dr.save(new Deck(name));
     return d;
 }

    /** save the specified deck **/
    public Deck saveDeck(Deck deck) {
        Deck d =dr.save(deck);
        return d;

    }

    /** get the deck with the specified name from the repository **/
    public Deck getDeck(String deckName) {
        return dr.findByName(deckName);
    }

    /** remove the deck with the specified name from the repository **/
    public boolean removeDeck(String deckName) {
        if (getDeck(deckName) != null) {
           Deck d = getDeck(deckName);
           dr.delete(d);
            return true;
        } else {
            return false;
        }
    }
    /** get all the decks from the repository **/
    public List<Deck> listDaDecks() {
        return dr.findAll();
    }
    /** shuffle the deck with specified name  **/
    public Deck shuffle(String deckName) {
        Deck cards = getDeck(deckName);
        if (cards != null) {
            cards = shuff.shuffle(cards);
            return dr.save(cards);
        } else {
            return null;
        }
    }
}
