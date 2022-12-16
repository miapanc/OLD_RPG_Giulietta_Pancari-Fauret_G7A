package com.isep.rpg.Hero;

//------CLASSE HUNTER------

import com.isep.rpg.Combatant;
import com.isep.rpg.Game;
import com.isep.rpg.Hero.Item.*;
import com.isep.rpg.Hero.*;

import java.util.WeakHashMap;

public class Hunter extends Hero {

    private Weapon weapon;
    private int damages;
    private String name;

    public Hunter(String name) {
        super(name, 0, 10); //0 points de mana et 10 points de vie
        this.name = name;
    }

    @Override
    public void fight(Combatant target) {
        boolean startFight = this.weapon.startFight();
        if (startFight) {
            System.out.println("Le joueur " + this.name + " inflige " + Integer.toString(this.damages) + " points de damages à" + target.getName());
            target.Damage(this.damages);
        } else {
            System.out.println("\n\n" + "Le joueur " + this.name + " à raté son attaque" + this.weapon.getName());
        }
    }

    public void chooseWeapons(int n) {
        Weapon item;
        System.out.println(n);
        switch (n) {
            case 1: //choix 1
                item = new Weapon("Bow");
                this.weapon = item;
                break;

            case 2: //choix 2
                item = new Weapon("Knife");
                this.weapon = item;
                break;
        }
        this.damages = this.weapon.getDamage();
    }

    @Override
    public void chooseItem(Items.Consumable.Consumable item) {
        int hp = item.getHealthPoint();
        super.earnHP(hp, item);
    }

    @Override
    public void addDamages(int n) {
        this.damages += n;
    }

    public String getWeaponName() {
        if (this.weapon != null)
            return this.weapon.getName();
        else
            return null;
    }

    public int getDamage() {
        return this.damages;
    }

}


    /*
    public int getArrows(){
        return this.arrows;
    }

    public int setArrows(int arrows){
        this.arrows = arrows;
    }

    public String getArmor(){
        return this.armor;
    }

    public void setArmor(String armor){
        this.armor = armor;
    }

    // Implémentation de la méthode abstraite "fight" par le hunter (=chasseur)
    @Override
    public void fight(Combatant combatant) {
        combatant.loose(weapon.getDamagePoints());
    }

    @Override
    public void take(Item item){
        if (item instanceof Weapon){
            weapon = (Weapon) item;
        } else {
            Game.displayMessage("Dommage... L'objet" + item.getName() + " sélectionné n'est pas utile ici.");
        }
    }

    private Weapon weapon;
    private int arrows;
    private String armor;

}

     */
