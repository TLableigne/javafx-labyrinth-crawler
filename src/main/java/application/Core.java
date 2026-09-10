package application;

import java.io.IOException;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.IVue;
import vue2D.sprites.ISprite;

/**
 *
 * @author arpecher
 */
public class Core {
    ISprite heros;
    ILabyrinthe labyrinthe;

    protected void initLabyrinthe() throws IOException {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
    }

    protected void initSprites(IVue vue) {
        // creation du heros
        personnages.Heros h = new personnages.Heros(labyrinthe.getEntree());
        this.heros = new vue2D.sprites.HerosSprite(h, labyrinthe);
        vue.add(this.heros);

        // Exercice 15 : Add 10 monsters
        java.util.List<ISalle> salles = new java.util.ArrayList<>(labyrinthe);
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            if (!salles.isEmpty()) {
                ISalle randomSalle = salles.get(rand.nextInt(salles.size()));
                personnages.Monstre monstre = new personnages.Monstre(randomSalle);
                vue2D.sprites.MonstreSprite ms = new vue2D.sprites.MonstreSprite(monstre);
                vue.add(ms);
            }
        }
    }

    protected void jeu(IVue vue) {
        // boucle principale
        ISalle destination = null;
        while (!labyrinthe.getSortie().equals(heros.getPosition())) {
            // ajustement etage courant: celui du héros
            labyrinthe.setEtageCourant(heros.getPosition().getEtage());
            // choix et deplacements de chaque sprite
            for (ISprite s : vue) {
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(s);
                destination = s.faitSonChoix(sallesAccessibles); // on demande au personnage de faire son choix de salle
                s.setPosition(destination); // deplacement

            }
            // detection des collisions
            boolean collision = false;
            ISprite monstre = null;
            for (ISprite s : vue) {
                if (s != heros) {
                    if (s.getPosition() == heros.getPosition()) {
                        System.out.println("Collision !!");
                        collision = true;
                        monstre = s;
                    }
                }
            }
            if (collision) {
                vue.remove(monstre);
                vue.remove(heros);
                System.out.println("Perdu !");
                System.out.println("Plus que " + vue.size() + " personnages ...");
            }

            temporisation(75);
        }
        System.out.println("Gagné!");
    }

    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        }
    }
}
