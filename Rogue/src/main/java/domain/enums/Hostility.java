package domain.enums;

public enum Hostility {
    LOW(2),
    MEDIUM(4),
    HIGH(6);

    private final int visibilityCell;

    Hostility(int visibilityCell) {
        this.visibilityCell = visibilityCell;
    }

    public int getVisibilityCell() {
        return visibilityCell;
    }
}
