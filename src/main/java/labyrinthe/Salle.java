/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labyrinthe;

import java.util.Objects;

/**
 * Représente une case (salle) du labyrinthe à une position donnée.
 *
 * @author tlableigne
 */
public class Salle implements ISalle {

    private int x;
    private int y;
    private ESalle type;
    private IEtage etage;

    /**
     * Crée une salle avec sa position (x, y), son type et son étage.
     */
    public Salle(int x, int y, ESalle type, IEtage etage) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.etage = etage;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public ESalle getType() {
        return this.type;
    }

    @Override
    public IEtage getEtage() {
        return this.etage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.x;
        hash = 19 * hash + this.y;
        hash = 19 * hash + Objects.hashCode(this.etage);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return Objects.equals(this.etage, other.etage);
    }

    /**
     * Vérifie si on peut passer directement de cette salle à une autre.
     */
    @Override
    public boolean estAdjacente(ISalle autre) {

        int dx = Math.abs(this.x - autre.getX());
        int dy = Math.abs(this.y - autre.getY());
        
        boolean memeEtage = this.etage.equals(autre.getEtage()) && (dx + dy == 1);
        
        if (memeEtage) {
            return true;
        }
        
        if (this.x == autre.getX() && this.y == autre.getY()) {
            
            boolean monter = (this.type == ESalle.ESCALIER_MONTANT && autre.getType() == ESalle.ESCALIER_DESCENDANT) && (this.etage.getNum() + 1 == autre.getEtage().getNum());
            boolean descendre = (this.type == ESalle.ESCALIER_DESCENDANT && autre.getType() == ESalle.ESCALIER_MONTANT) && (this.etage.getNum() - 1 == autre.getEtage().getNum());
        
            return monter || descendre;
        }
        
        return false;
    }
}


