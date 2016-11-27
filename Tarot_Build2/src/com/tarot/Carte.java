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

public class Carte {
    int x, y, z;
    ImageView devant = new ImageView();
    ImageView dos = new ImageView();
    static Image imageDos = new Image("file:./resources/272px-Tarot_nouveau_-_Grimaud_-_1898_-_Back_side.jpg");
    static long halfFlipDuration = 1000;

    Carte(int x, int y, int z, String fichier){
        Image imageDevant = new Image("file:./resources/271px-Tarot_nouveau_-_Grimaud_-_1898_-"+fichier);
        devant.setImage(imageDevant);
        devant.setTranslateX(x);
        devant.setTranslateY(y);
        devant.setTranslateZ(z);
        dos.setImage(imageDos);
        dos.setTranslateX(x);
        dos.setTranslateY(y);
        dos.setTranslateZ(z);
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
        return new SequentialTransition(rotateOutFront, rotateInBack);
    }

}
