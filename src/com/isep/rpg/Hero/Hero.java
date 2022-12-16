package com.isep.rpg.Hero;

//------CLASSE HERO------

import com.isep.rpg.Combatant;
import com.isep.rpg.*;
import com.isep.rpg.Hero.Item.*;

public abstract class Hero extends Combatant {

    public Hero(String name, int mana, int h) {
        super(name,0,10); //super permet d’utiliser le constructeur de la classe mère
        //le Hero n'a pas de points de mana (c'est que pour les SpellCaster
        //il a 10 points de vie
    }

    public void earnHP(int n, Item item){
        super.earnHP(n,item);
    }

    // Abstrait car n'importe quel hero peut prendre un objet mais son
    // utilisation dépend du type du héro (ex: une arme n'est pas utile à un mage)
    public abstract void chooseItem(Items.Consumable.Consumable item);

    //public abstract void use (Item item);

}
