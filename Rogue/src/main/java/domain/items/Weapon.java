package domain.items;

import domain.abstact.Items;
import domain.common.Coord;
import domain.enums.WeaponE;

public class Weapon extends Items {
    private WeaponE weapon;
    private final Coord coord;

    public Weapon(WeaponE weapon, int x, int y){
        super(weapon.getSymbol(), weapon.getName(), weapon.getIncrease());
        coord = new Coord(x, y);
    }

    public WeaponE getWeapon() {
        return weapon;
    }

    public Coord getCoord() {
        return coord;
    }
}
