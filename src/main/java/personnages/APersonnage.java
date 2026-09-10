package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

public abstract class APersonnage implements IPersonnage {
    private ISalle position;

    @Override
    public ISalle getPosition() {
        return position;
    }

    @Override
    public void setPosition(ISalle s) {
        this.position = s;
    }
}
