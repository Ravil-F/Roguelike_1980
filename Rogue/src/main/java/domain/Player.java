package domain;

import domain.abstact.Attributes;
import domain.enums.Color;
import domain.Coord;
import domain.interfaces.Move;

public class Player extends Attributes implements Move {
    private Coord coord;
    public Player(String name, char symbol, Color color, int maxHealth, int health, int agility, int strength) {
        super(name, symbol, color, maxHealth, health, agility, strength);
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(int x, int y) {
        this.coord.setX(x);
        this.coord.setY(y);
    }

    @Override
    public int MovePlaeyr(int a, boolean bol) {
        if (bol) return ++a;
        else return --a;
    }
}
