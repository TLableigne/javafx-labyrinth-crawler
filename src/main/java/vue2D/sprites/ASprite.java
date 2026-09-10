package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import personnages.IPersonnage;
import labyrinthe.ISalle;
import java.util.Collection;

public abstract class ASprite implements ISprite {

    protected IPersonnage personnage;
    protected int xpix;
    protected int ypix;
    protected Image image;

    public ASprite(IPersonnage p) {
        this.personnage = p;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        if (image != null) {
            g.drawImage(image, xpix, ypix);
        }
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        this.xpix = xpix;
        this.ypix = ypix;
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return personnage.faitSonChoix(sallesAccessibles);
    }

    @Override
    public ISalle getPosition() {
        return personnage.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {
        personnage.setPosition(s);
    }
}
