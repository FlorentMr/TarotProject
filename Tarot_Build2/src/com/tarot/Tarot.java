package com.tarot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Swagzenegger on 27/11/2016.
 */
public class Tarot {
    private Image image;
        public static void main(String[] args) {
        final String nom = "Florent Mariotti";
        Modele model = new Modele();
        Controleur control = new Controleur(model);
        Window window = new Window("Tarot  - MVC -fmariotti",model,control);
        Carte carte = new Carte(512-(271/2),200,200,"1.jpg");
    }
}
