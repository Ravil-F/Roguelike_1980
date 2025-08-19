package domain.items;

import domain.abstact.Items;
import domain.enums.WeaponE;

public class Weapon extends Items {
    private WeaponE weapon;

    public WeaponE(WeaponE weapon){
        super(weapon.getSymbol(), weapon.getName(), weapon.getIncrease());
    }

    public WeaponE getWeapon() {
        return weapon;
    }
}
