package domain.abstact;

import com.googlecode.lanterna.TextCharacter;
import domain.enums.Color;
import domain.Coord;

//сущность
public abstract class Entity {
    private String name;
    private char symbol;
    private Color color;
    private Coord coord;

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

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(int x, int y) {
        this.coord = coord.add(x, y);
    }

    public Entity(String name, char symbol, Color color, int x, int y) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
        this.coord = new Coord(x, y);
    }
}
