package vue2D.sprites;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import personnages.IPersonnage;
import personnages.Heros;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import java.util.Collection;

public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    private ILabyrinthe labyrinthe;

    public HerosSprite(IPersonnage p, ILabyrinthe labyrinthe) {
        super(p);
        this.labyrinthe = labyrinthe;
        this.image = new Image("file:icons/link/LinkRunShieldL1.gif");
    }

    @Override
    public void handle(KeyEvent event) {
        if (!(this.personnage instanceof Heros)) return;
        
        Heros heros = (Heros) this.personnage;
        ISalle current = heros.getPosition();
        if (current == null) return;
        
        int targetX = current.getX();
        int targetY = current.getY();
        int targetEtage = current.getEtage().getNum();
        
        switch (event.getCode()) {
            case LEFT:
                targetX--;
                break;
            case RIGHT:
                targetX++;
                break;
            case UP:
                targetY--;
                break;
            case DOWN:
                targetY++;
                break;
            case M:
                targetEtage++;
                break;
            case D:
                targetEtage--;
                break;
            default:
                return;
        }

        Collection<ISalle> accessibles = labyrinthe.sallesAccessibles(this);
        for (ISalle s : accessibles) {
            if (s.getX() == targetX && s.getY() == targetY && s.getEtage().getNum() == targetEtage) {
                heros.setSalleChoisie(s);
                return;
            }
        }
    }
}
