package tarot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.*;

public class Window extends Vue {


    private static final long serialVersionUID = 8431930309001023920L;
    protected JFrame frame;
    protected Label emptyLabel;
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("TimerViewAll  update");
        //jtext.setText("   "+model.getHeure()+":"+model.getMinute()+" - "+model.getSeconde());
    }

    public Window (String label, Modele modele, Controleur controleur) {
        //super(label, modele, controleur);
        frame = new JFrame("FrameDemo");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}