package domain.utils;

import domain.enums.MapE;

public class Utils {

    public Utils(){}

    public boolean isWithinBounds(int x, int y) {
        return x > 0 && y > 0 && x < MapE.WIDTH_HEIGHT.getWidth() && y < MapE.WIDTH_HEIGHT.getWidth();
    }

    public boolean isWithinBounds(int x) {
        return x > 0 && x < MapE.WIDTH_HEIGHT.getWidth();
    }

}
