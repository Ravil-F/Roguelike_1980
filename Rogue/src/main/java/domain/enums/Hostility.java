package domain.enums;

public enum Hostility {
    LOW(1),
    MEDIUM(3),
    HIGH(5);

    private final int visibilityCell;

    Hostility(int visibilityCell) {
        this.visibilityCell = visibilityCell;
    }

    public int getVisibilityCell() {
        return visibilityCell;
    }
}
