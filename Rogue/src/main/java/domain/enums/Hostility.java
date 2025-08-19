package domain.enums;

public enum Hostility {
    LOW(2),
    MEDIUM(4),
    HIGH(6);

    private final int hostilityType;

    Hostility(int  hostilityType) {
        this. hostilityType =  hostilityType;
    }

    public int getVisibilityCell() {
        return  hostilityType;
    }
}
