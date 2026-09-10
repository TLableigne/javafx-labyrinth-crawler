package vue2D.javafx;

import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;

/**
 *
 * @author INFO Professors team
 */
public class Vue extends AVue implements IVue {

    Dessin dessin;
    ILabyrinthe labyrinthe;
    public Scene scene;

    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }

    @Override
    public void dessiner() {
        // recopie du fond (image); murs + salles
        dessin.dessinFond();
        dessin.dessinSalles(labyrinthe.getEtageCourant());        // ...
        
        // dessiner les sprites
        for (ISprite s : this) {
            if (s.getPosition() != null && s.getPosition().getEtage() == labyrinthe.getEtageCourant()) {
                int targetX = s.getPosition().getX() * AVue.UNITE;
                int targetY = s.getPosition().getY() * AVue.UNITE;
                
                if (s instanceof vue2D.sprites.ASprite) {
                    vue2D.sprites.ASprite as = (vue2D.sprites.ASprite) s;
                    int currentX = as.getXpix();
                    int currentY = as.getYpix();
                    int step = 2;
                    
                    if (currentX < targetX) currentX = Math.min(currentX + step, targetX);
                    if (currentX > targetX) currentX = Math.max(currentX - step, targetX);
                    if (currentY < targetY) currentY = Math.min(currentY + step, targetY);
                    if (currentY > targetY) currentY = Math.max(currentY - step, targetY);
                    
                    s.setCoordonnees(currentX, currentY);
                } else {
                    s.setCoordonnees(targetX, targetY);
                }
                
                s.dessiner(dessin.getGraphicsContext2D());
            }
        }
    }

    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        // si le sprite est controle par le clavier
        if (sprite instanceof javafx.event.EventHandler) {
            System.out.println("registering keylistener");
            // association de l'ecouteur sur le clavier avec le composant graphique principal
            this.scene.setOnKeyPressed((javafx.event.EventHandler) sprite);
        }
        return true;
    }

}
