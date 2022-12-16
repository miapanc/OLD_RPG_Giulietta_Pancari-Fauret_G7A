package Items.Consumable;

//------CLASSE CONSUMABLE------

import com.isep.rpg.Hero.Item.*;

public abstract class Consumable extends Item {
    public Consumable(String name) {
        super(name);
        }

        public abstract int getHealthPoints();
}
