/**
 * Created by Florent Mariotti.
 */

package tarot;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/*public class Tarot {
    private Image image;

    public static void main(String[] args) {
        final String nom = "Florent Mariotti";
        tarot.Modele model = new tarot.Modele();
        tarot.Controleur control = new tarot.Controleur(model);
        tarot.Window window = new tarot.Window("Tarot  - MVC -fmariotti", model, control);
        tarot.Carte carte = new tarot.Carte(512 - (271 / 2), 200, 200, "1.jpg");

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
    @Override

    public void start(Stage fenetre) throws InterruptedException {

        Deck deck = new Deck();
        Modele modele = new Modele(deck);
        Controleur controleur = new Controleur(modele);


        // scene graphique
        fenetre.setTitle("Tarot de Florent Mariotti");

        modele.setCards();

        Scene plateau = new Scene(modele.cartes,1024,768);
        plateau.setFill(Color.BLACK);

        fenetre.setScene(plateau);
        fenetre.sizeToScene();
        fenetre.show();

        modele.setAnimations();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
