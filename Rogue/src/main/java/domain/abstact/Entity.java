package domain.abstact;

public abstract class Entity {
    private String name;
    private char symbol;
    private byte color;

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

    public byte getColor() {
        return color;
    }

    public void setColor(byte color) {
        this.color = color;
    }

    public Entity(String name, char symbol, byte color){
        this.name = name;
        this.symbol = symbol;
        this.color = color;
    }
}
