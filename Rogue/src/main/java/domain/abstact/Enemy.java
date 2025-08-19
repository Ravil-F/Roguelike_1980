package domain.abstact;

import domain.abstact.Attributes;
import domain.enums.EnemyType;
import domain.enums.Hostility;

//враг
public abstract class Enemy extends Attributes {
//    private EnemyType enemyType;
    private final Hostility hostility;


    public Enemy(EnemyType enemyType, int x, int y){
        super(enemyType.getName(), enemyType.getSymbol(), enemyType.getColor(), enemyType.getMaxHealth(), enemyType.getHealth(), enemyType.getAgality(), enemyType.getStrength(), x, y);
        this.hostility = enemyType.getHostility();
    }

    public Hostility getHostility() {
        return hostility;
    }
}
