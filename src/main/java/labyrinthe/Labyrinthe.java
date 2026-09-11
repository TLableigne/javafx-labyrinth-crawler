package labyrinthe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import personnages.IPersonnage;

/**
 * Représente le labyrinthe complet (un ensemble de salles).
 *
 * @author professor team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    private IEtage etageCourant = new Etage();
    private ISalle entree;
    private ISalle sortie;

    /**
     * Crée le labyrinthe en chargeant les étages depuis des fichiers.
     * Cherche et définit l'entrée et la sortie.
     */
    public Labyrinthe() throws IOException {
        super();
        IEtage etage1 = new Etage(1);
        IEtage etage2 = new Etage(2);
        try {
            etage1.charger("etages/etage1N.txt");
            etage2.charger("etages/etage2N.txt");
            this.etageCourant = etage1;
            this.addAll(etage1);
            this.addAll(etage2);
            /*
            String[] fichiers = {"etages/etage1N.txt", "etages/etage2N.txt"};
            for (int i = 0; i < fichiers.length; i++) {
                Etage etage = new Etage(i + 1);
                setEtageCourant(etage);
                etage.charger(fichiers[i]);
                this.addAll(etage);*/
        } catch (IOException e) {
            System.out.println(e);
        }
        for (ISalle s : this) {
            if (s.getType() == ESalle.ENTREE) {
                this.entree = s;
            }
            if (s.getType() == ESalle.SORTIE) {
                this.sortie = s;
            }
        }
    }

    /**
     * Retourne les salles où le héros peut se déplacer depuis sa position.
     */
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage heros) {
        Collection<ISalle> accessibles = new ArrayList<>();
        ISalle pos = heros.getPosition();

        if (pos == null || this.etageCourant == null) {
            return accessibles;
        }

        for (ISalle s : this) {
            if (pos.estAdjacente(s)) {
                accessibles.add(s);
            }
        }

        return accessibles;
    }

    /**
     * Retourne la salle d'entrée du labyrinthe.
     */
    @Override
    public ISalle getEntree() {
        return this.entree;
    }

    /**
     * Retourne la salle de sortie du labyrinthe.
     */
    @Override
    public ISalle getSortie() {
        return this.sortie;
    }

    /**
     * Retourne l'étage actuel où se trouve le joueur.
     */
    @Override
    public IEtage getEtageCourant() {
        return this.etageCourant;
    }

    /**
     * Change l'étage actuel.
     */
    @Override
    public void setEtageCourant(IEtage etage) {
        this.etageCourant = etage;
    }

    /**
     * Calcule le chemin pour aller d'une salle à une autre.
     */
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

}
