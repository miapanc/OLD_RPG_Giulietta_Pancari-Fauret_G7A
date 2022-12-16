package com.isep.rpg.Hero;

//------CLASSE HEALER------

import com.isep.rpg.Combatant;
import com.isep.rpg.Game;
import com.isep.rpg.Hero.Item.*;


public class Healer extends SpellCaster {

    //********* Déclaration des variables utilisées *********
    private String name; //nom du Healer
    private int mana;
    private Weapon weapon;

    //*********            Constructeur             *********

    public Healer (String name, int h, int mana) {
        super(name, 10, 8);
        //super : prend les paramètres de la classe SpellCaster
        //ici on a 10 points de vie et 8 points de mana au début
        this.name = name;
        this.mana = mana;
        //récupère le nom et points de mana de l'objet utilisé (le Healer)
    }

    //*********         Fonctions utilisées         *********

    //Fonction qui ajoute des points de mana au Healer
    @Override
    public void addMana(int mana){
        this.mana += mana;
    }

    //Fonction qui récupère les points de mana actuels (pour ensuite les afficher ailleurs)
    @Override
    public int getMana(){
        return this.mana;
    }

    //Fonction qui récupère le nombre de points dont on a besoin pour lancer le sort
    //Et si on en a pas assez on peut pas lancer de sort
    @Override
    public int getSpellNeededPoints(){
        return this.getSpellNeededPoints().;
    }

    public int getDamagePoints(){
        return this.getDamagePoints();
    }

    @Override
    public void fight(Combatant target) {
       if (this.mana <= 0){
           System.out.println("Le combatant " + this.name + " n'a plus de point de mana...");
           this.mana = 0;
       }
    }

    /*@Override
    public void chooseItem(Items.Consumable.Consumable item)
    {
        int hp = item.getHealingPoints();
        super.gainHP(hp,item);
        addMana(hp*2);
    }
     */

/*
    @Override
    public void take (Item item){
        if (item instanceof Weapon){
            weapon = (Weapon) item;
        } else {
            Game.displayMessage("Dommage... L'objet " + item.getName() + " sélectionné n'est pas utile ici.");
        }
        //boucle if : si l'item sélectionné est bien dans l'intance Weapon
        //on le prend, mais si il n'existe pas on affiche le message
    }

    public void potionHealer(Combatant combatant){
        //on vérifie que le Healer a suffisamment de mana pour soigner avec une potion
        if (getMana() >= 2){ //si le Healer a au moins 2 points de mana...
            setMana(getMana()-2); //on lui enlève 2 points de mana
            combatant.win(30); //on donne au combattant +30 hp
            System.out.println(getName() + " lance un sort pour soigner " + combatant + " !");
        } else {
            System.out.println(getName() + " a besoin de plus de mana pour lancer un sort de soin...");
        }
    } */

}
