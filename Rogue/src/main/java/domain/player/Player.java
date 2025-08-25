package domain.player;

import domain.abstact.Attributes;
import domain.abstact.Items;
import domain.backpack.Backpack;
import domain.enums.ColorE;
import domain.interfaces.Move;

public class Player extends Attributes implements Move {
    private Backpack backpack;

    public Player(){
        super("Player", '@', ColorE.RED, 100, 100, 0, 0, 5, 5);
        backpack = new Backpack();
    }

    public Player(String name, char symbol, ColorE color, int maxHealth, int health, int agility, int strength, int x, int y) {
        super(name, symbol, color, maxHealth, health, agility, strength, x, y);
        backpack = new Backpack();
    }

    @Override
    public int MovePlayer(int a, boolean bol) {
        if (bol) return ++a;
        else return --a;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Items item) {
        backpack.add(item);
    }
}
