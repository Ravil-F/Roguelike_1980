package domain;

import domain.abstact.Attributes;
import domain.enums.Color;

public class Player extends Attributes {
    public Player(String name, char symbol, Color color, int maxHealth, int health, int agility, int strength) {
        super(name, symbol, color, maxHealth, health, agility, strength);
    }

}
