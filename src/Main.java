//-----------TP4 : Mini RPG Lite 3000------------
//Auteur : Pancari-Fauret Giulietta
//Date : 21 octobre jusqu'à décembre 2022

import com.isep.rpg.*;

public class Main {
    public static void main(String[] args) {
        Runtime.getRuntime() addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Interruption");
            }
        });
    }
}