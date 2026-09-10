package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

public class Heros extends APersonnage {
    private ISalle salleChoisie;

    public Heros(ISalle positionInitiale) {
        this.setPosition(positionInitiale);
    }

    public ISalle getSalleChoisie() {
        return salleChoisie;
    }

    public void setSalleChoisie(ISalle salleChoisie) {
        this.salleChoisie = salleChoisie;
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (salleChoisie != null && sallesAccessibles.contains(salleChoisie)) {
            return salleChoisie;
        }
        return getPosition();
    }
}
