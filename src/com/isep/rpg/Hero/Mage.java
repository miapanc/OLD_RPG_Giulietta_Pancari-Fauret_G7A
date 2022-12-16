package com.isep.rpg.Hero;

import com.isep.rpg.Combatant;
import com.isep.rpg.Game;
import com.isep.rpg.Hero.Item.*;
import com.isep.rpg.Hero.Item.Consumable.*;
import com.isep.rpg.Hero.SpellCaster;

public class Mage extends SpellCaster {

    private String name;
    private int mana;

    public Mage(String name)
    {
        super(name,10,8);
        this.name = name;
        this.mana = 8;
    }

    @Override
    public void addMana(int n) {
        this.mana += n;
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public void fight(Combatant target) {
        if (this.mana <= 0) {
            System.out.println("Le joueur " + this.name + " n'a plus de points de mana...");
            this.mana = 0;
        }
    }

    public void chooseWeapons(int n) {
        Weapon item;
        System.out.println(n);
        switch (n) {
            case 1: //choix 1
                item = new Weapon("Spell");
                this.weapon = item;
                break;

            case 2: //choix 2
                item = new Weapon("Hypnose");
                this.weapon = item;
                break;
        }
        this.damages = this.weapon.getDamage();
    }

    @Override
    public void addDamages(int n) {
        this.addDamages(n);
    }

    @Override
    public void chooseItem(Items.Consumable.Consumable item)
    {
        int hp = item.getHealthPoint();
        super.earnHP(hp,item);
        addMana(hp*2);
    }

}
