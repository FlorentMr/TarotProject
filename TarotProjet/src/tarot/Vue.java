package tarot;

/**
 * Created by Florent Mariotti.
 */

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observer;


public abstract class Vue implements Observer{
    private static final long serialVersionUID = -721683694272838181L;
    protected Modele model;
    protected Controleur control;
    ArrayList<Observer> observers;

    public Vue(String nom, Modele mod, Controleur cont, Stage fenetre)
    {
        this.model = mod;
        this.control = cont;
        fenetre.setTitle(nom);
    }

    public Vue()
    {
        this.model=null; this.control=null;
    }

    public void setWindow(Stage fenetre){
        Scene plateau = new Scene(model.cartes,1024,768);
        plateau.setFill(Color.BLACK);

        fenetre.setScene(plateau);
        fenetre.sizeToScene();
        fenetre.show();
    }
}