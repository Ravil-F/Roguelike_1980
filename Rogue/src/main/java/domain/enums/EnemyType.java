package domain.enums;
import domain.enums.Hostility;
import domain.enums.Color;
//типы врагов
public enum EnemyType {
    ZOMBI("Zombi", 'Z',  Color.GREEN ,100, 100, 25, 50, Hostility.LOW),
    VAMPIRE("Vampire", 'V', Color.RED , 100, 100, 100, 50, Hostility.HIGH),
    GROST("Grost", 'G', Color.WHITE, 25, 25, 100, 25, Hostility.LOW),
    ORGE("Orge", 'O', Color.YELLOW, 100, 100, 25, 100, Hostility.MEDIUM),
    SNAKE_MAGE("Sname Mage", 'S', Color.WHITE, 50, 50, 100, 50, Hostility.HIGH);

//    private final String enemyType;
    private final String name;
    private final char symbol;
    private final Color color;
    private final int maxHealth;
    private final int health;
    private final int agality;
    private final int strength;
    private final Hostility hostility;

    EnemyType(String name, char symbol, Color color, int maxHealth, int health, int agality, int strength, Hostility hostility) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
        this.maxHealth = maxHealth;
        this.health = health;
        this.agality = agality;
        this.strength = strength;
        this.hostility = hostility;
    }


    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public Color getColor() {
        return color;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getAgality() {
        return agality;
    }

    public int getStrength() {
        return strength;
    }

    public Hostility getHostility() { return  hostility; }
}
