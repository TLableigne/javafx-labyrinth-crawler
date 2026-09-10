package vue2D.sprites;

import javafx.scene.image.Image;
import personnages.IPersonnage;

public class MonstreSprite extends ASprite {

    public MonstreSprite(IPersonnage p) {
        super(p);
        this.image = new Image("file:icons/monstre1.gif");
    }
}
