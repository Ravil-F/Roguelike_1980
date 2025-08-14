package domain.abstact;

import com.googlecode.lanterna.TextCharacter;
import domain.enums.Color;

//сущность
public abstract class Entity {
    private String name;
    private char symbol;
    private Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Entity(String name, char symbol, Color color) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
    }
}
