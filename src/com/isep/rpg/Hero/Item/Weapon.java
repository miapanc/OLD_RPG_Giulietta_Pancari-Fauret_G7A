package Items;

//------CLASSE WEAPON------

import com.isep.rpg.Hero.Item.*;

public class Weapon extends Item {

    //********* Déclaration des variables utilisées *********
    private String name; //nom du Healer
    private int mana;
    private int damages;
    private int healthPoints;
    private int manaNeededPoints;


    public Weapon(String name) {
        super(name);
        this.name = name;

        // switch = if plus élaboré
        // si l'arme sélectionnée est ... elle infligera x points de dégâts
        switch (name){
            // Armes du Warrior
            case "Sword":
                this.damages = 3;
                break;

            case "Punch":
                this.damages = 1;
                break;

            // Armes du Hunter
            case "Bow":
                this.damages = 2;
                break;

            case "Knife":
                this.damages = 2;
                break;

            // Armes du Mage
            case "Spell":
                this.damages = 3;
                break;

            case "Hypnose":
                this.damages = 1;
                break;

            // Armes du Healer
            case "Potion":
                this.healthPoints = 4;
                break;
        }
    }

    public int getDamage() {
        return this.damages;
    }

}
