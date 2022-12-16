package com.isep.rpg;

//------CLASSE COMBATANT------

public abstract class Combatant{

    private String name; //"private" encapsulation = rien n'a accès à name
    private int healthPoints; //points de vie
    private int maxHealthPoints;
    private int mana;


    public Combatant(String name, int mana, int healthPoints){ //nom du paramètre = nom de l'attribut
        this.name = name;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.mana = mana;

    }

    public String getName (){
        return this.name;
    }

    public int getHealthPoint(){
        return this.healthPoints;
    }

    public int Damage(int n){
        if (this healthPoints <= 0){
            this.healthPoints = 0;
            System.out.println("Oh non ! " + this.name + " est mort !");
        }
    }

    public void Healing(int n) {
        this.healthPoints += n;
        /*if(this.healthPoints > this.maxHealthPoints){
            this.healthPoints = this.maxHealthPoints;
          }
         */
    }

    public void earnHP(int n, Item item){
        this.healthPoints += n;
        if (this.healthPoints > this.maxHealthPoints && item instanceof Items.Consumable.Food) {
            System.out.println("Le max de points de vie est déjà atteint, votre personnage a " + this.maxHealthPoints + " HP.");
            this.healthPoints = this.maxHealthPoints;
        }
    }

    public int getMana(){
        return this.mana;
    }

    public void addMana(int n){
        this.mana += n;
    }

    public abstract void Fight(Combatant target);
    //public abstract void fight(Combatant combatant); //test unitaire sur méthode fight
    //vide car héros peut être magicien ou combatant
    //on va la renommer dans classe Héros par exemple car pour l'instant on ne sait pas qui va commencer le fight

}
