package domain.enums;

public enum Common {
    MAX_LEVEL(10);

    private final int maxLevel;

    Common(int maxLevel){
        this.maxLevel = maxLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
}
