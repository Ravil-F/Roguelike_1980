package domain.player;

import domain.abstact.Attributes;

import domain.enums.ColorE;

public class Player extends Attributes {

    public Player() {
        super("Player", '@', ColorE.RED, 100, 100, 0, 0, 5, 5);
    }

    public Player(String name, char symbol, ColorE color, int maxHealth, int health, int agility, int strength, int x, int y) {
        super(name, symbol, color, maxHealth, health, agility, strength, x, y);
    }

    public void increaseStrenght(int xp){
        int res = getStrength() + xp;
        System.out.println("res: " + res);
        setStrength(res);
    }

    public void increaseHealth(int a){
        setHealth(getHealth() + a);
    }

}
