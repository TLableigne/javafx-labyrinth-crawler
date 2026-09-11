package vue2D.sprites;

import javafx.scene.image.Image;
import personnages.IPersonnage;

/**
 * L'image graphique représentant un monstre à l'écran.
 */
public class MonstreSprite extends ASprite {

    /**
     * Crée l'affichage d'un monstre avec son image.
     */
    public MonstreSprite(IPersonnage p) {
        super(p);
        this.image = new Image("file:icons/monstre1.gif");
    }
}
