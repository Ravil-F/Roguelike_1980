package domain;

import domain.abstact.Attributes;
import domain.enums.ColorE;
import domain.interfaces.Move;

public class Player extends Attributes implements Move {


    public Player(String name, char symbol, ColorE color, int maxHealth, int health, int agility, int strength, int x, int y) {
        super(name, symbol, color, maxHealth, health, agility, strength, x, y);
    }

    @Override
    public int MovePlayer(int a, boolean bol) {
        if (bol) return ++a;
        else return --a;
    }
}
