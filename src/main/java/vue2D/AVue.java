package vue2D;
import java.util.concurrent.CopyOnWriteArrayList;

import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

/**
 * Vue abstraite qui contient les éléments graphiques (sprites) à afficher.
 *
 * @author INFO Professors team
 */
public abstract class AVue extends CopyOnWriteArrayList<ISprite> implements IVue{
    public static final int UNITE = 20;
    
    /**
     * Ajoute un élément graphique (sprite) et calcule sa position à l'écran.
     */
    @Override
    public boolean add(ISprite sprite){
    	super.add(sprite);
    	ISalle s = sprite.getPosition();
    	sprite.setCoordonnees(s.getX()*UNITE,s.getY()*UNITE);
    	return true;
    }

}
