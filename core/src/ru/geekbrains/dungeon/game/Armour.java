// 5. * Добавьте доспехи/броню с сопротивляемостью к разным видам оружия

package ru.geekbrains.dungeon.game;

import lombok.Data;
import lombok.Getter;
import ru.geekbrains.dungeon.game.units.Unit;

import java.lang.invoke.SwitchPoint;

@Getter
public class Armour {

    private enum ArmourType {
        TYPE_0(0, "Without armour"),
        TYPE_1(1, "Squama"),
        TYPE_2(2, "Hauberk"),
        TYPE_3(3, "Plate armour");

        int armourIndex;
        String armourName;

        ArmourType(int armourIndex, String armourName) {
            this.armourIndex = armourIndex;
            this.armourName = armourName;
        }

        public static ArmourType getArmour(int armourIndex) {
            switch (armourIndex) {
                case 0:
                    return TYPE_0;
                case 1:
                    return TYPE_1;
                case 2:
                    return TYPE_2;
                case 3:
                    return TYPE_3;
                default:
                    return TYPE_0;
            }
        }

        public String toString() {
            return armourName;
        }
    }

    private ArmourType type;

    public Armour(ArmourType type) {
        this.type = type;
    }

    public Armour(int indexType) {
        this.type = ArmourType.getArmour(indexType);
    }

    public int getTypeNumber() {
        return type.ordinal();
    }

    public String toString() {
        return (type.toString());
    }
}

