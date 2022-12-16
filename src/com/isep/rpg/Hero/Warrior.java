package com.isep.rpg.Hero;

//------CLASSE WARRIOR------

import com.isep.rpg.Hero.Item.*;
import com.isep.rpg.*;

public class Warrior extends Hero {


    private String name;
    private Weapon weapon;
    private int damages;

    public Warrior(String name) {
        super(name,0,10); // 0 mana et 10 hp
        this.name = name;
    }

    @Override
    public void fight(Combatant target)
    {
        boolean startFight = this.weapon.startFight();
        if (startFight) {
            System.out.println("Le joueur " + this.name + " inflige " + Integer.toString(this.damages) + " points de damages à" + target.getName());
            target.Damage(this.damages);
        } else {
            System.out.println("\n\n" + "Le joueur " + this.name + " à raté son attaque" + this.weapon.getName());
        }
    }

    public void chooseWeapons(int n)
    {
        Weapon item;
        switch(n)
        {
            case 1:
                item = new Weapon("Sword");
                this.weapon = item;
                break;

            case 2:
                item = new Weapon("Punch");
                this.weapon = item;
                break;
        }
        this.damages = this.weapon.getDamage();
    }

    @Override
    public void chooseItem(Items.Consumable.Consumable item) {
        int hp = item.getHealthPoint();
        super.earnHP(hp,item);
    }

    @Override
    public void addDamages(int n) {
        this.damages += n;
    }

    public String getWeaponName()
    {
        if(this.weapon != null)
            return this.weapon.getName();
        else
            return null;
    }

    public int getDamage()
    {
        return this.damages;
    }

}