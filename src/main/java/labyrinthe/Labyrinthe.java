package labyrinthe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import personnages.IPersonnage;

/**
 *
 * @author professor team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    private IEtage etageCourant = new Etage();
    private ISalle entree;
    private ISalle sortie;

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

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage heros) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ISalle getEntree() {
        return this.entree;
    }

    @Override
    public ISalle getSortie() {
        return this.sortie;
    }

    @Override
    public IEtage getEtageCourant() {
        return this.etageCourant;
    }

    @Override
    public void setEtageCourant(IEtage etage) {
        this.etageCourant = etage;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

}
