package tarot;

/**
 * Created by Florent Mariotti.
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private List<Carte> deck = new LinkedList<Carte>();
    public Deck() {
        int y=0; int x=0;
        for(Carte.Couleur suit : Carte.Couleur.values()) {
            for(Carte.ValeurNormale value : Carte.ValeurNormale.values()) {
                x+=20;
                deck.add(new Carte(x,y,200,value.value+""+suit.couleur +".jpg"));
                System.out.println(value.value+""+suit.couleur);
            }
        }
        for(Carte.ValeurAtout value : Carte.ValeurAtout.values()) {
            x+=20;
            deck.add(new Carte(x,y,200,value.value+".jpg"));
            System.out.println(value.value);
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Carte piocheCarte() {
        Carte tmp;
        tmp = deck.get(0);
        deck.remove(0);
        return tmp;
    }

    public Carte getCarte(int i) {
        return deck.get(i);
    }
}