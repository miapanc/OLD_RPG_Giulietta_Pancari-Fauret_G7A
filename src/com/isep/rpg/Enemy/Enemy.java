package com.isep.rpg.Enemy;

//------CLASSE ENEMY------

import com.isep.rpg.Combatant;

public abstract class Enemy extends Combatant {

    private String name;
    private int damagePoints;
    private int healthPoints;

    public Enemy(String name, int h, /*int damagePoints*/) {
        super(name, 10, 50); //super : permet de prendre les paramètres de la classe Combatant (mère)
        // Enemy a 10 points de mana et 50 points de vie
    }

    @Override
    public void Fight(Combatant target){
        target.Damage(this.damagePoints);
    }

    public int getDamagePoints(){
        return this.damagePoints;
    //Les points de dégats sont infligés aux ennemis (ils n'ont pas d'armes)
    }
}
