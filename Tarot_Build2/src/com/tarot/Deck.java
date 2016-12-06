package com.tarot;

/**
 * Created by Swagzenegger on 06/12/2016.
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private List<Carte> deck = new LinkedList<Carte>();
    public Deck() {
        int y=0; int x;
        for(Carte.Suit suit : Carte.Suit.values()) {
            x=0;
            y+=50;
            for(Carte.Value value : Carte.Value.values()) {
                x+=50;
                deck.add(new Carte(x,y,200,value.value+""+suit.symbol+".jpg"));
                System.out.println(value.value+""+suit.symbol);
            }
        }
        shuffle();
    }
    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Carte piocheCarte() {
        if (deck.size() == 52) {
            shuffle();
        }
        Carte temp;
        temp = deck.get(0);
        deck.remove(0);
        return temp;
    }
}
