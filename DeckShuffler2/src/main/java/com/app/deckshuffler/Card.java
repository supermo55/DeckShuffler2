package com.app.deckshuffler;

public class Card {

/** declare a suit and rank instance to be used by card **/
    Suit s;
    Rank r;

    public Card(Suit s, Rank r)
    {
       this.s=s;
       this.r=r;
    }

    public Rank getR() {
        return r;
    }

    public Suit getS() {
        return s;
    }

    public void setR(Rank r) {
        this.r = r;
    }

    public void setS(Suit s) {
        this.s = s;
    }
    public String toString(){
        return getR().toString()+"-"+getS().toString();
    }
}
