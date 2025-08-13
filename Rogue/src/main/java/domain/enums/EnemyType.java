package domain.enums;

//типы врагов
public enum EnemyType {
    ZOMBI("Zombi"),
    VAMPIRE("Vampire"),
    GROST("Grost"),
    ORGE("Orge"),
    SNAKE_MAGE("Sname Mage");

    private final String enemyType;

    EnemyType(String enemyType) {this.enemyType = enemyType; }

    public String getEnemyType() {
        return enemyType;
    }
}
