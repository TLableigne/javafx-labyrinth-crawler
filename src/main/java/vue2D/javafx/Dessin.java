package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.AVue;
import vue2D.sprites.ISprite;
import labyrinthe.IEtage;

/**
 * Zone de dessin (Canvas) où les éléments graphiques du jeu sont tracés.
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    private Collection<ISprite> sprites;
    private int unite;

    // donnees labyrinthe labyrinthe
    private ILabyrinthe labyrinthe;
    private ISalle entree;
    private ISalle sortie;
    private int largeur;
    private int hauteur;

    private GraphicsContext tampon;
    private Image murImage;
    private Image solImage;
    private Image salleImage;
    private Image escalierM;
    private Image escalierD;
    private int tailleLinkH = 6;
    private int tailleLinkL = 2;

    /**
     * Initialise la zone de dessin et charge les images.
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.labyrinthe = labyrinthe;
        this.sprites = sprites;
        this.unite = AVue.UNITE;
        entree = labyrinthe.getEntree();
        sortie = labyrinthe.getSortie();
        largeur = labyrinthe.getEtageCourant().getLargeur();
        hauteur = labyrinthe.getEtageCourant().getHauteur();
        setWidth(largeur * unite);
        setHeight(hauteur * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
    }

    /**
     * Charge toutes les images du jeu (murs, sols, escaliers).
     */
    public void chargementImages() {
        murImage = new Image("file:icons/mur2.gif");
        solImage = new Image("file:icons/pyramide.png");
        salleImage = new Image("file:icons/ground.gif");
        escalierM = new Image("file:icons/up.gif");
        escalierD = new Image("file:icons/down.gif");
    }

    /**
     * Dessine l'image de fond sur tout l'écran.
     */
    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * largeur,
                unite * hauteur);
    }

    /**
     * Dessine toutes les salles de l'étage, avec un effet d'ombre autour du héros.
     */
    public void dessinSalles(IEtage etage) {
        ISalle heroPos = null;
        for (ISprite s : sprites) {
            if (s instanceof vue2D.sprites.HerosSprite) {
                heroPos = s.getPosition();
                break;
            }
        }

        for (ISalle s : etage) {
            Color c = Color.rgb(200, 200, 200);
            dessinSalle(s, c);
            
            if (heroPos != null) {
                int dx = Math.abs(s.getX() - heroPos.getX());
                int dy = Math.abs(s.getY() - heroPos.getY());
                int dist = dx + dy;
                
                double opacity = Math.min(dist * 0.15, 1.0);
                if (opacity > 0) {
                    tampon.setFill(new Color(0, 0, 0, opacity));
                    tampon.fillRect(s.getX() * unite, s.getY() * unite, unite, unite);
                }
            }
        }
    }

    /**
     * Dessine une seule salle à l'écran selon son type (normale, escalier...).
     */
    public void dessinSalle(ISalle s, Color c) {
        int x = s.getX() * unite;
        int y = s.getY() * unite;
        switch (s.getType()) {
            case NORMALE ->
                tampon.drawImage(salleImage, x, y, unite, unite);
            case ESCALIER_MONTANT ->
                tampon.drawImage(escalierM, x, y, unite, unite);
            case ESCALIER_DESCENDANT ->
                tampon.drawImage(escalierD, x, y, unite, unite);
        }
    }
    

    /**
     * Affiche le plus court chemin vers la sortie.
     */
    public void dessinPlusCourtChemin(ISprite p) {
        // ...
    }

}
