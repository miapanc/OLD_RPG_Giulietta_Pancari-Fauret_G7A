package com.isep.rpg.Hero;

import com.isep.rpg.Hero.*;
import com.isep.rpg.Combatant;

public class SpellCaster extends Hero {
    public SpellCaster(String name, int mana) {
        super(name,8, 10); //8 mana et 10 hp
    }

    public abstract void chooseWeapon(int n);
    public abstract String getWeaponName();
    public abstract int getWeaponDamage();

}
