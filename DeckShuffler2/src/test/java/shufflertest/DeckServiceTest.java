package shufflertest;

import com.app.Application;
import com.app.deckshuffler.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.ContextConfiguration;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = Application.class)
@WebMvcTest(DeckController.class)
public class DeckServiceTest {

    @Mock
    DeckRepository dr;

    @Mock
    Shuffler shuff;

    @InjectMocks
    DeckService ds;

    @Test
    public void createDeckTest() throws Exception
    {
        Deck d = new Deck("deck1");
        Mockito.when(dr.save(Mockito.any())).thenReturn(d);
        Deck d2 =ds.createDeck("deck1");
        assertEquals(d,d2);


    }

    @Test
    public void getDeckTest() throws Exception
    {
        Deck d = new Deck("deck1");
        Mockito.when(dr.findByName("deck1")).thenReturn(d);
        Deck copy =ds.getDeck("deck1");
        assertEquals(d,copy);
    }

    @Test
    public void listDecksTest() throws Exception
    {
        ArrayList<Deck> mockDecks = new ArrayList<Deck>();
        mockDecks.add(new Deck("deck1"));
        mockDecks.add(new Deck("deck2"));
        mockDecks.add(new Deck("deck3"));
        Mockito.when(dr.findAll()).thenReturn(mockDecks);
        ArrayList<Deck> decks = (ArrayList<Deck>) ds.listDaDecks();
        assertEquals(decks,mockDecks);

    }
    public Deck shuffle(Deck d) {

        ArrayList<Card> cards = d.getDeck();
        Collections.shuffle(cards);
        d.setDeck(cards);
        return d;
    }

    @Test
    public void shuffleTest() throws Exception
    {
        Deck d = new Deck("deck1");
        Deck b = shuffle(new Deck("deck1"));
        Mockito.when(dr.save(Mockito.any())).thenReturn(b);
        Mockito.when(dr.findByName("deck1")).thenReturn(d);
        Mockito.when(shuff.shuffle(d)).thenReturn(b);
        Deck shuffled =ds.shuffle("deck1");
        assertNotEquals(d.getDeck().get(0).toString(),shuffled.getDeck().get(0).toString());

    }
}
