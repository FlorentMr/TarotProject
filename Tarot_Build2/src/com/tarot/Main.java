package com.tarot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

/**
 * Created by Swagzenegger on 27/11/2016.
 */
/*public class Tarot {
    private Image image;

    public static void main(String[] args) {
        final String nom = "Florent Mariotti";
        Modele model = new Modele();
        Controleur control = new Controleur(model);
        Window window = new Window("Tarot  - MVC -fmariotti", model, control);
        Carte carte = new Carte(512 - (271 / 2), 200, 200, "1.jpg");

        Group cartes = new Group();
        Scene plateau = new Scene(cartes, 1024, 768);
        plateau.setFill(Color.BLACK);

        cartes.getChildren().addAll(carte.getNodes());
        window.setScene(plateau);
        window.sizeToScene();
        window.show();
    }
}*/

public class Main extends Application {
    public final static int xMain=50;
    public final static int yMain=500;
    public final static int zMain=200;
    @Override

    public void start(Stage fenetre) throws InterruptedException {
        Carte carte = new Carte();
        Deck deck = new Deck();
        ArrayList<Carte> carteAnimer = new ArrayList<Carte>();



        // scene graphique
        fenetre.setTitle("Let's play Tarot !");
        Group cartes = new Group();

        for (int i=0;i<16;i++)
        {
            carte=deck.piocheCarte();
            carte.setTranslation(i*xMain+100,yMain,200);
            cartes.getChildren().addAll(carte.getNodes());
            carteAnimer.add(carte);
        }

        Scene plateau = new Scene(cartes,1024,768);
        plateau.setFill(Color.BLACK);

        fenetre.setScene(plateau);
        fenetre.sizeToScene();
        fenetre.show();

        // animation
        for (int i=0;i<16;i++) {
            carteAnimer.get(i).flip().play();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
