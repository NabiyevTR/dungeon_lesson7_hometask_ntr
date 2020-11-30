package ru.geekbrains.dungeon.game;

import com.badlogic.gdx.math.MathUtils;
import ru.geekbrains.dungeon.game.units.Unit;

public class BattleCalc {
    public static int attack(Unit attacker, Unit target) {
        int out = getDamage(attacker.getWeapon(), target.getArmour());

        //out -= target.getStats().getDefence();
        /*if (out < 0) {
            out = 0;
        }*/

        return out;

    }

    public static int checkCounterAttack(Unit attacker, Unit target) {
        if (MathUtils.random() < 0.5f) {
            int amount = attack(target, attacker);
            return amount;
        }
        return 0;
    }

    private static int getDamage(Weapon weapon, Armour armour) {
        int defence = getDefence(weapon, armour);
        return weapon.getDamage() - defence > 0 ? weapon.getDamage() - defence : 0;
    }

    private static int getDefence(Weapon weapon, Armour armour) {
        return BattleCalc.DEFENCE_ARRAY[armour.getTypeNumber()][weapon.getTypeNumber()];
    }


    //Двухмерный массив для определения защиты: По горизонтали - оружие / По вертикали - броня
    // Не уверен, что он должен быть здесь
    public final static int[][] DEFENCE_ARRAY = new int[][]{
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 2, 1, 1, 1},
    };
}
