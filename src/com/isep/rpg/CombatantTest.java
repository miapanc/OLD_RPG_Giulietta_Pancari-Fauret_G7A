package com.isep.rpg;

import Enemy.DeathEaters;

import Hero.Warrior;
import Items.Weapon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//------CLASSE COMBATANT TEST------


public class CombatantTest {
    @Test
    void fightTest(){
        Warrior w = new Warrior("Harry", 5); //5 = nombre de points de vie
        Weapon sword = new Weapon("sword", 1);
        w.take(sword);
        DeathEaters d = new DeathEaters("Spiked Magyar", 5);
        d.fight(w); //lancement combat
        w.fight(d);
        assertTrue(d.getHealthPoint() == 4);
        //assertEquals(2, getHealthPoint());
    }
}
