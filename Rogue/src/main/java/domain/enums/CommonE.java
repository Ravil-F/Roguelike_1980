package domain.enums;

public enum CommonE {
    MAX_LEVEL(21);

    private final int maxLevel;

    CommonE(int maxLevel){
        this.maxLevel = maxLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
}
