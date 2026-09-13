package personnages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import labyrinthe.ISalle;

/**
 * Représente un monstre dans le labyrinthe.
 * Il se déplace de façon aléatoire.
 */
public class Monstre extends APersonnage {
    private Random rand;

    /**
     * Crée un monstre et le place dans une salle de départ.
     */
    public Monstre(ISalle positionInitiale) {
        this.setPosition(positionInitiale);
        this.rand = new Random();
    }

    /**
     * Choisit une salle au hasard parmi celles accessibles pour s'y déplacer.
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (sallesAccessibles == null || sallesAccessibles.isEmpty()) {
            return getPosition();
        }
        List<ISalle> listeSalles = new ArrayList<>(sallesAccessibles);
        int index = rand.nextInt(listeSalles.size());
        return listeSalles.get(index);
    }
}
