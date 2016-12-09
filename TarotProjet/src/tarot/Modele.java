package tarot;

/**
 * Created by Florent Mariotti.
 */

import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Observable;

public class Modele extends Observable {
    public Deck deckM;
    private Carte carte;
    public Group cartes = new Group();
    public ArrayList<Carte> carteAutres = new ArrayList<Carte>();
    public ArrayList<Carte> carteJoueur = new ArrayList<Carte>();
    public ArrayList<Carte> carteChien = new ArrayList<Carte>();

    public final static int xMain = 50;
    public final static int xMain2 = 1024 / 2;
    public final static int yMain = 300;
    public final static int zMain = 550;
    public final static int NB_CARTES_MAIN = 18;
    public final static int NB_CARTES_DECK = 78;
    public final static int LeftRightBands = (1024 - (50 * 18)) / 2 - 22;

    public Modele(Deck deck) {
        deckM = deck;
    }

    public Modele() {
    }

    public void setCards() {
        for (int i = 0; i < NB_CARTES_DECK; i++) {
            carte = deckM.getCarte(i);
            carte.setTranslationDevant(900 / 2, 600 / 2, zMain);
            carte.setTranslationDos(i * xMain, yMain, zMain);
            cartes.getChildren().addAll(carte.getNodes());
        }
        for (int i = 0; i < NB_CARTES_MAIN; i++) {
            carte.setters(LeftRightBands + xMain * i, yMain, zMain);
            carte = deckM.piocheCarte();
            carteJoueur.add(carte);
        }
        for (int i = 0; i < NB_CARTES_MAIN * 3; i++) {
            carte.setters(LeftRightBands + xMain * i, yMain, zMain);
            carte = deckM.piocheCarte();
            carteAutres.add(carte);
        }
        for (int i = 0; i < 6; i++) {
            carte.setters(350 + xMain * i, 200, zMain);
            carte = deckM.piocheCarte();
            carteChien.add(carte);
        }
    }

    public void setAnimations() {
        for(int i=0;i<6;i++) {
            for (int j=0;j<3;j++) {
                this.carteJoueur.get(3*i+j).translationBas().play();
                this.carteAutres.get(9*i+j).translationDroite().play();
                this.carteAutres.get(9*i+j+3).translationHaut().play();
                this.carteAutres.get(9*i+j+6).translationGauche().play();
                if (i<2)
                    this.carteChien.get(3*i+j).translationChien().play();
            }
        }
    }

    public void update() {
    }

}