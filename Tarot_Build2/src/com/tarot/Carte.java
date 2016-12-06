package com.tarot ;

import java.util.ArrayList;
import java.util.Collection;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Carte extends Modele{
    int X, Y, Z;
    ImageView devant = new ImageView();
    ImageView dos = new ImageView();
    static Image imageDevant = new Image("file:./ressources/cache.jpg");
    static long halfFlipDuration = 1000;
    String fichierName;

    Carte(){}

    Carte(int x, int y, int z, String fichier){
        Image imageDos = new Image("file:./ressources/"+fichier);
        devant.setImage(imageDevant);

        dos.setImage(imageDos);

        fichierName=fichier;
    }

    public void setTranslation(int x, int y, int z){
        devant.setTranslateX(x);
        devant.setTranslateY(y);
        devant.setTranslateZ(z);

        dos.setTranslateX(x);
        dos.setTranslateY(y);
        dos.setTranslateZ(z);
    }

    public String image () {return fichierName;}

    public enum Value {
        AS(1),
        DEUX(2),
        TROIS(3),
        QUATRE(4),
        CINQ(5),
        SIX(6),
        SEPT(7),
        HUIT(8),
        NEUF(9),
        DIX(10),
        VALET(11),
        CAVALIER(12),
        DAME(13),
        ROI(14);

        public final int value;
        Value(int c) {
            value = c;
        }
       // private int getValue(){return (int)Value.;}
    }

    public enum Suit {
        TREFLES('T'),
        PIQUES('P'),
        CARREAUX('K'), //Pour ne pas avoir de problème d'identification par symbole entre "Coeur" et "Carreau", on donne à ce dernier la valeur 'K'
        COEURS('C');

        public final char symbol;
        Suit(char c) {
            symbol = c;
        }
    }

    Collection<Node> getNodes(){
        ArrayList<Node> al = new ArrayList<>();
        al.add(devant);
        al.add(dos);
        return al;
    }

    Transition flip() {
        final RotateTransition rotateOutFront = new RotateTransition(Duration.millis(halfFlipDuration), devant);
        rotateOutFront.setInterpolator(Interpolator.LINEAR);
        rotateOutFront.setAxis(Rotate.Y_AXIS);
        rotateOutFront.setFromAngle(0);
        rotateOutFront.setToAngle(90);
        //
        final RotateTransition rotateInBack = new RotateTransition(Duration.millis(halfFlipDuration), dos);
        rotateInBack.setInterpolator(Interpolator.LINEAR);
        rotateInBack.setAxis(Rotate.Y_AXIS);
        rotateInBack.setFromAngle(-90);
        rotateInBack.setToAngle(0);
        //
        return new SequentialTransition(rotateInBack, rotateOutFront);
    }

}
