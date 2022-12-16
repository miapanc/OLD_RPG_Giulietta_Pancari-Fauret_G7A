package com.isep.rpg.Enemy;

//------CLASSE DRAGON------

import com.isep.rpg.Combatant;

public class DeathEaters extends Enemy {

    public DeathEaters(String n, int h, int damagePoints){
        //Le dragon possède 5 points de vie et inflige 2 points de dégats
        super(n, h, damagePoints);
    }

    // Implémentation de la méthode abstraite "fight" par le dragon
    @Override
    public void fight(Combatant combatant) {
        combatant.loose(getDamagePoints());
    }
}
