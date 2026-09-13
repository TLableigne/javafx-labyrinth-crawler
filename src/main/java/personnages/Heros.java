package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 * Représente le joueur (héros) dans le labyrinthe.
 * Se déplace selon les commandes du clavier.
 */
public class Heros extends APersonnage {
    private ISalle salleChoisie;

    /**
     * Crée le héros et le place dans sa première salle.
     */
    public Heros(ISalle positionInitiale) {
        this.setPosition(positionInitiale);
    }

    /**
     * Donne la prochaine salle visée par le joueur.
     */
    public ISalle getSalleChoisie() {
        return salleChoisie;
    }

    /**
     * Enregistre la prochaine salle où le joueur veut aller.
     */
    public void setSalleChoisie(ISalle salleChoisie) {
        this.salleChoisie = salleChoisie;
    }

    /**
     * Choisit la salle où se déplacer, en fonction de la touche pressée par le joueur.
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (salleChoisie != null && sallesAccessibles.contains(salleChoisie)) {
            return salleChoisie;
        }
        return getPosition();
    }
}
