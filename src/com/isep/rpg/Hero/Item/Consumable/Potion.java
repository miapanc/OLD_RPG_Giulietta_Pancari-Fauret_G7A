package Items.Consumable;

//------CLASSE POTION------

import Items.Consumable.Consumable;

public class Potion extends Consumable {

    private int strength;

    public Potion(String name){
        super(name);
        switch (name){
            case "Pumpkin Juice":
                this.strength = 2;
                break;

            case "Chocolate Frog":
                this.strength = 3;
                break;

            case "Giant Pizza":
                this.strength = 5;
                break;

        }
    }

    @Override
    public int getHealthPoints(){
        return this.strength;
    }
}
