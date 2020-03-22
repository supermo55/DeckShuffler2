package com.app.deckshuffler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/decks")
public class DeckController {
    @Autowired
    DeckService ds;
    /** get method to list the decks **/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Deck>> listDecks()
    {
        return ResponseEntity.ok(ds.listDaDecks());
    }

    /** put method to create a deck given deckName **/
    @PutMapping(value = "/createDeck/{deckName}")
    public ResponseEntity<Deck> createDeck(@PathVariable("deckName") String deckName)
    {
        return ResponseEntity.ok(ds.createDeck(deckName));
    }

    /** get method to get a specific deck given deckName **/
    @RequestMapping(value = "/{deckName}", method = RequestMethod.GET)
    public ResponseEntity<Deck> getDeck(@PathVariable("deckName") String deckName)
    {
        return ResponseEntity.ok(ds.getDeck(deckName));
    }
    /** delete method to delete a specific deck given deckName from the list of decks **/
    @RequestMapping(value = "/delete/{deckName}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteDeck(@PathVariable("deckName") String deckName)
    {
        return ResponseEntity.ok(ds.removeDeck(deckName));
    }

    /** post method to shuffle a specific deck given deckName **/
    @RequestMapping(value = "/shuffle/{deckName}", method = RequestMethod.POST)
    public ResponseEntity<Deck> shuffleDeck(@PathVariable("deckName") String deckName)
    {
        return ResponseEntity.ok(ds.shuffle(deckName));
    }

}