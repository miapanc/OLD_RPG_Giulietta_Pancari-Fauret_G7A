package com.isep.rpg;

//------CLASSE GAME------

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.isep.rpg.Hero.Item.*;
import com.isep.rpg.Hero.*;
import com.isep.rpg.Enemy.*;

import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

    public class Game {

        //Theme song pour le jeu en continue
        String filePath = "src/Wednesday-Main-Titles_1.wav";
        try {
            // Charger le fichier audio
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(filePath));

            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);

            // Lecture en boucle
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

        catch (Exception e){
            e.printStackTrace();
        }


        //définition des couleurs et fonds
        public static final String ROUGE = "\u001B[31m";
        public static final String NOIR = "\u001B[30m";
        public static final String BLANC = "\u001B[37m";
        public static final String FOND_NOIR = "\u001B[40m";
        public static final String FOND_ROUGE = "\u001B[41m";
        public static final String FOND_BLANC = "\u001B[47m";

        public static final String RESET = "\u001B[0m";


        public Game() {

            // PAGE D'ACCUEIL DU JEU
            System.out.println(FOND_ROUGE);
            System.out.println(BLANC + "\t\t VOICI LE JEU DE RÔLE LE PLUS ATTENDU DE L'ANNÉE . . ." + RESET + FOND_ROUGE);
            System.out.println(FOND_NOIR + BLANC + "\r\n\t Attention, tenez vous prêt ! Voici le déroulement du jeu :" + RESET + FOND_NOIR);
            System.out.println(FOND_NOIR + BLANC + "\r\n\t- 1 - \uD83E\uDDD9\u200D♂️ Choisis le nombre de héros que tu veux dans ta partie ");
            System.out.println("\r\n\t- 2 - Choisis le type de héros que tu veux entre : les Warriors \uD83D\uDDE1️ (ils n'ont pas froid aux yeux), les Hunters \uD83C\uDFF9 (ils sont habiles de leur flèches), les Healers \uD83E\uDDEA (on en a toujours besoin) et les Mages \uD83E\uDDD9\u200D♂️ (ce sont eux les plus malins)) ");
            System.out.println("\r\n\t- 3 - Choisis des noms pour tes héros, donne leur de la vie, choisis leur des armes et les points de dégâts qu'elles infligeront à tes ennemis !");
            System.out.println("\r\n\t Es-tu prêt jeune padawan ? (non le thème n'est pas Star Wars..)");
            System.out.println("\r\n\t Que l'aventure commence !");
            System.out.println(FOND_NOIR);
            System.out.println(RESET);

            //this.inputParser = inputParser;

            heros = new ArrayList<>();

            String classeChoisie = "";
            String namePlayer;
            String weapon;
            int hp;
            int damagePoints;

            Scanner scanner0 = new Scanner(System.in);
            System.out.print(ROUGE + "\r\n\tAvec combien de héros veux-tu jouer jeune padawan ? ");
            int nb_combatant = scanner0.nextInt(); //nombre de héros

            for (int i = 1; i <= nb_combatant; i++){
                System.out.println("\r\n\t--------------------------\r\n");

                // Boucle while : tant que la classe n'est pas bien orthographiée ou aucune des classes existantes,
                // on redemande au joueur ce qu'il veut :
                while (!classeChoisie.equals("Warrior") & !classeChoisie.equals("Hunter") & !classeChoisie.equals("Healer") & !classeChoisie.equals("Mage")){
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("\tQuel est le type de héros avec lequel tu veux jouer ?");
                    System.out.print(i);
                    System.out.print(" Warrior, Hunter, Healer ou Mage ?");
                    classeChoisie = scanner1.nextLine();
                }

                Scanner scanner2 = new Scanner(System.in);
                System.out.print("\tQuel nom veux-tu donner à ton " + classeChoisie + " ?");
                namePlayer = scanner2.nextLine();

                Scanner scanner3 = new Scanner(System.in);
                System.out.print("\tCombien de points de vie veux-tu donner à " + namePlayer + "?");
                hp = scanner3.nextInt();

                Scanner scanner4 = new Scanner(System.in);
                System.out.print("\tQuelle arme veux-tu donner à " + namePlayer + " ?");
                weapon = scanner4.nextLine();

                Scanner scanner5 = new Scanner(System.in);
                System.out.print("\tCombien de dégats fera l'arme de " + namePlayer + " ?");
                damagePoints = scanner5.nextInt();

                this.createHero(classeChoisie, namePlayer, hp, weapon, damagePoints);
                classeChoisie = "";
            }

            String Jouer;


                    System.out.println(RESET);
                    Scanner scannerJeu = new Scanner(System.in);
                    System.out.println(FOND_NOIR);
                    System.out.println(RESET);
                    System.out.println("\r\n\t" + YELLOW + "Pour jouer, appuyez sur entrer ! \r\n");
                    Jouer = scannerJeu.nextLine();
                    System.out.println(FOND_NOIR);
                    System.out.println(RESET);

                    if (Jouer.equals("")) {
                        System.out.println();
                    }

                    enemies = new ArrayList<>();

                    for (int j = 1; j <= nb_combatant; j++){

                        Random random = new Random();
                        int nb;
                        nb = random.nextInt(5)+1;

                        this.createEnemy(nb);
                    }
                }

                public void createHero(String classe, String n, int h, String name_arme, int damagePoints) {
                    Hero hero = switch (classe) {
                        case "Warrior" -> new Warrior(n, h);
                        case "Hunter" -> new Hunter(n, h);
                        case "Healer" -> new Healer(n, h);
                        case "Mage" -> new Mage(n, h);
                        default -> new Warrior(n, h);
                    };
                    hero.setWeapon(new Weapon(name_arme, damagePoints));
                    heros.add(hero);
                }

                public void createEnemy(Integer nb){

                    Enemy enemy = switch (nb) {
                        case 1 -> new Dragon("Dragon");
                        case 2 -> new Gobelin("Gobelin");
                        case 3 -> new Golem("Golem");
                        case 4 -> new Lama("Lama");
                        case 5 -> new Minotaure("Minotaure");
                        default -> new Dragon("Dragon");
                    };

                    enemies.add(enemy);
                }
                private Combatant goodOne;
                private Combatant badOne;
                public void start() {

                    int ixHero = 0;

                    // Boucle de jeu
                    while (true) {

                        displayStatus(heros, enemies);

                        goodOne = heros.get(ixHero);
                        badOne = enemies.get(0);

                        // Attaque de l'ennemi
                        displayMessage("\r\nLe vilain " + badOne.getName()
                                + " attaque le gentil " + goodOne.getName() + "...");
                        badOne.fight(goodOne);
                        if (goodOne.getHealthPoint() <= 0) {
                            displayMessage
                                    ("\r\n" + FOND_ROUGE + "Oh nan ! Le pauvre " + goodOne.getName() + " a été vaincu..." + RESET);
                            heros.remove(ixHero);
                            ixHero--; // Correction: évite que le suivant perde son tour
                        } else {

                            this.playerTurn();

                            if (badOne.getHealthPoint() <= 0) {
                                displayMessage("\r\n" + FOND_VERT + "Bien joué, " + goodOne.getName()
                                        + " a vaincu " + badOne.getName() + " !!!" + RESET );
                                enemies.remove(0);
                            }

                        }

                        // Tests de fin du jeu
                        if (heros.size() == 0) {
                            displayMessage(FOND_ROUGE + "Malheureusement, les héros ont perdu, c'est la fin du monde..." + RESET);
                            break;
                        }
                        if (enemies.size() == 0) {
                            displayMessage(FOND_VERT + "BRAVO, les héros ont gagné, le monde est sauvé !!!" + RESET);
                            System.out.println(RESET);
                            break;
                        }

                        // Au tour du héro suivant
                        ixHero = (ixHero + 1) % heros.size();
                    }
                }

                private void playerTurn() {
                    /*
                     * Demander valeur à l'utilisateur
                     * if attaquer
                     * mettre les 3 lignes du bas
                     * if utiliser un consomable
                     * afficher actions non implémentées, vous avez perdu votre tour
                     * if se défendre
                     * afficher actions non implémentées, vous avez perdu votre tour
                     */

                    String nb;
                    Scanner scannerZ = new Scanner(System.in);
                    System.out.print(BLUE + "\r\nQue voulez vous faire ? (Attaquer, Consommer, Se défendre) " + RESET);
                    nb = scannerZ.nextLine();



                    switch (nb) {
                        case "Attaquer" : // Riposte du gentil, s'il n'est pas vaincu
                            ((Hero) goodOne).looseProtection();
                            displayMessage("Le gentil " + goodOne.getName()
                                    + " attaque le vilain " + badOne.getName() + "...");
                            goodOne.fight(badOne);
                            break;

                        case "Consommer" : ((Hero) goodOne).looseProtection();
                            break;


                        case "Se défendre" : // Divise les dégats subies pendant 1 tour
                            ((Hero) goodOne).looseProtection();
                            ((Hero) goodOne).addProtection();
                            break;

                    }

                }

                private InputParser inputParser;

                private final List<Combatant> heros;
                private final List<Combatant> enemies;


                // Méthodes d'affichage
                // (STATIQUES pour pouvoir les appeler depuis n'importe où dans le programme)
                //
                // => pourraient éventuellement être déplacées dans le package
                //    "com.isep.utils", en s'inspirant de "InputParser" (méthodes de saisie)

                private boolean firstTour = true;
                public void displayStatus(List<Combatant> h, List<Combatant> e) {

                    if (!this.firstTour) {
                        System.out.println("\r\n===== TOUR SUIVANT =====\r\n");
                    }
                    firstTour = false;

                    for (Combatant c : h) {
                        System.out.print(c.getName() + " (" + c.getHealthPoint() + " ♥) ");
                    }
                    System.out.println("\r\n" + FOND_NOIR + RED + "VS" + RESET);
                    for (Combatant c : e) {
                        System.out.print(c.getName() + " (" + c.getHealthPoint() + " ♥) ");
                    }
                    System.out.println();

                }

                public static void displayMessage(String message) {
                    System.out.println(message);
                }

}