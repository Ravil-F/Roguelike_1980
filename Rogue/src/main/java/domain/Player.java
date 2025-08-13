package domain;

import domain.abstact.Attributes;

public class Player extends Attributes {
    public Player(String name, char symbol, byte color, int maxHealth, int health, int agility, int strength) {
        super(name, symbol, color, maxHealth, health, agility, strength);
    }

}
