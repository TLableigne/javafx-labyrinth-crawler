package personnages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import labyrinthe.ISalle;

public class Monstre extends APersonnage {
    private Random rand;

    public Monstre(ISalle positionInitiale) {
        this.setPosition(positionInitiale);
        this.rand = new Random();
    }

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
