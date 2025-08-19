package domain;
import domain.abstact.Enemy;
import domain.enums.EnemyType;

public class Zombi extends Enemy{
    public Zombi(EnemyType enemyType, int x, int y) {
        super(enemyType, x, y);
    }
}
