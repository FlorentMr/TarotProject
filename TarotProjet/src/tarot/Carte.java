package tarot;

/**
 * Created by Florent Mariotti.
 */

import java.util.ArrayList;
import java.util.Collection;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Carte extends Modele {
    int X, Y, Z;
    ImageView devant = new ImageView();
    ImageView dos = new ImageView();
    static Image imageDevant = new Image("file:./ressources/cache.jpg");
        static long halfFlipDuration = 1000;
    String fichierName;


    Carte(int x, int y, int z, String fichier) {
        X=x;Y=y;Z=z;
        Image imageDos = new Image("file:./ressources/" + fichier);
        devant.setImage(imageDevant);
        devant.setFitHeight(145);
        devant.setFitWidth(75);

        dos.setImage(imageDos);
        dos.setFitHeight(145);
        dos.setFitWidth(75);

        fichierName = fichier;
    }

    Carte(){}

    public void setTranslationDevant(int x, int y, int z) {
        devant.setTranslateX(x);
        devant.setTranslateY(y);
        devant.setTranslateZ(z);
    }

    public void setTranslationDos(int x, int y, int z) {
        dos.setTranslateX(x);
        dos.setTranslateY(y);
        dos.setTranslateZ(z);
    }

    public enum ValeurNormale {
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

        ValeurNormale(int c) {
            value = c;
        }
    }

    public enum ValeurAtout{
        UN(1),
        DEUX(2),
        TROIS(3),
        QUATRE(4),
        CINQ(5),
        SIX(6),
        SEPT(7),
        HUIT(8),
        NEUF(9),
        DIX(10),
        ONZE(11),
        DOUZE(12),
        TREIZE(13),
        QUATORZE(14),
        QUINZE(15),
        SEIZE(16),
        DIX_SEPT(17),
        DIX_HUIT(18),
        DIX_NEUF(19),
        VINGT(20),
        VINGT_ET_UN(21),
        EXCUSE(22);

        public final int value;

        ValeurAtout(int c) {
            value = c;
        }
    }

    public enum Couleur {
        TREFLES('T'),
        PIQUES('P'),
        CARREAUX('K'), //Pour ne pas avoir de problème d'identification par symbole entre "Coeur" et "Carreau", on donne à ce dernier la valeur 'K'
        COEURS('C');

        public final char couleur;

        Couleur(char c) {
            couleur = c;
        }
    }

    public void setters (int x, int y, int z){
        this.X=x;
        this.Y=y;
        this.Z=z;
    }

    Collection<Node> getNodes() {
        ArrayList<Node> al = new ArrayList<>();
        al.add(devant);
        al.add(dos);
        return al;
    }

    Transition translationChien() {
        devant.setTranslateX(900/2);
        devant.setTranslateY(600/2);
        devant.setTranslateZ(200);

        final TranslateTransition translation = new TranslateTransition(Duration.millis(1500), devant);
        translation.setByX(1024/2*1.0f);
        translation.setByY(768/2*1.0f);
        translation.setToX(this.X);
        translation.setToY(200);
        translation.setAutoReverse(true);
        //
        final RotateTransition rotateOutFront = new RotateTransition(Duration.millis(halfFlipDuration), devant);
        rotateOutFront.setInterpolator(Interpolator.LINEAR);
        rotateOutFront.setAxis(Rotate.Y_AXIS);
        rotateOutFront.setFromAngle(0);
        rotateOutFront.setToAngle(90);
        //
        dos.setTranslateX(this.X);
        dos.setTranslateY(200);
        dos.setTranslateZ(200);
        //
        final RotateTransition rotateInBack = new RotateTransition(Duration.millis(halfFlipDuration), dos);
        rotateInBack.setInterpolator(Interpolator.LINEAR);
        rotateInBack.setAxis(Rotate.Y_AXIS);
        rotateInBack.setFromAngle(-90);
        rotateInBack.setToAngle(0);
        //
        return new SequentialTransition(translation, rotateOutFront, rotateInBack);
    }

    Transition translationHaut() {
        devant.setTranslateX(900/2);
        devant.setTranslateY(600/2);
        devant.setTranslateZ(200);

        final TranslateTransition translation = new TranslateTransition(Duration.millis(1500), devant);
        translation.setByX(1024/2*1.0f);
        translation.setByY(768/2*1.0f);
        translation.setToX(this.X);
        translation.setToY(-1000);
        translation.setAutoReverse(true);

        return new SequentialTransition(translation);
    }

    Transition translationGauche() {
        devant.setTranslateX(900/2);
        devant.setTranslateY(600/2);
        devant.setTranslateZ(200);

        final TranslateTransition translation = new TranslateTransition(Duration.millis(1500), devant);
        translation.setByX(1024/2*1.0f);
        translation.setByY(768/2*1.0f);
        translation.setToX(-1000);
        translation.setToY(768/2*1.0f);
        translation.setAutoReverse(true);

        return new SequentialTransition(translation);
    }

    Transition translationDroite() {
        devant.setTranslateX(900/2);
        devant.setTranslateY(600/2);
        devant.setTranslateZ(200);

        final TranslateTransition translation = new TranslateTransition(Duration.millis(1500), devant);
        translation.setByX(1024/2*1.0f);
        translation.setByY(768/2*1.0f);
        translation.setToX(1500);
        translation.setToY(768/2*1.0f);
        translation.setAutoReverse(true);

        return new SequentialTransition(translation);
    }

    Transition translationBas() {
        devant.setTranslateX(900/2);
        devant.setTranslateY(600/2);
        devant.setTranslateZ(200);

        final TranslateTransition translation = new TranslateTransition(Duration.millis(1500), devant);
        translation.setByX(1024/2*1.0f);
        translation.setByY(768/2*1.0f);
        translation.setToX(this.X);
        translation.setToY(550);
        translation.setAutoReverse(true);
        //
        final RotateTransition rotateOutFront = new RotateTransition(Duration.millis(halfFlipDuration), devant);
        rotateOutFront.setInterpolator(Interpolator.LINEAR);
        rotateOutFront.setAxis(Rotate.Y_AXIS);
        rotateOutFront.setFromAngle(0);
        rotateOutFront.setToAngle(90);
        //
        dos.setTranslateX(this.X);
        dos.setTranslateY(550);
        dos.setTranslateZ(200);
        //
        final RotateTransition rotateInBack = new RotateTransition(Duration.millis(halfFlipDuration), dos);
        rotateInBack.setInterpolator(Interpolator.LINEAR);
        rotateInBack.setAxis(Rotate.Y_AXIS);
        rotateInBack.setFromAngle(-90);
        rotateInBack.setToAngle(0);
        //
        return new SequentialTransition(translation, rotateOutFront, rotateInBack);
    }
}
