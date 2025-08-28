package domain.enums;

public enum MapE {
    WIDTH_HEIGHT (20);

    private final int wh;

    MapE(int wh){
        this.wh = wh;
    }

    public int getWidth() {
        return wh;
    }
}
