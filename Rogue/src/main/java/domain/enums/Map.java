package domain.enums;

public enum Map {
    WIDTH_HEIGHT (20);

    private final int wh;

    Map(int wh){
        this.wh = wh;
    }

    public int getWidth() {
        return wh;
    }
}
