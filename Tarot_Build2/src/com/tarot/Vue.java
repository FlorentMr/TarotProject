package com.tarot;

/**
 * Created by Swagzenegger on 27/11/2016.
 */

import java.util.ArrayList;
import java.util.Observer;
import javax.swing.JFrame;


public abstract class Vue extends JFrame implements Observer{
    private static final long serialVersionUID = -721683694272838181L;
    protected Modele model;
    protected Controleur control;
    ArrayList<Observer> observers;

    public Vue(String nom, Modele mod, Controleur cont)
    {
        super(nom);
        this.model = mod;
        this.control = cont;
        this.setTitle("modele.Tarot de " + nom + "S3A");
        this.setBounds(50, 50, 500, 500);
        model.addObserver(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        observers = new ArrayList<Observer>();
    }

    public Vue()
    {
        this.model=null; this.control=null;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}