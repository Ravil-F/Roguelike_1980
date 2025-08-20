package domain.items;

import domain.abstact.Items;
import domain.common.Coord;
import domain.enums.ScrollE;

public class Scroll extends Items {
    private ScrollE scroll;
    private final Coord coord;

    public Scroll(ScrollE scroll, int x, int y){
        super(scroll.getSymbol(), scroll.getName(), scroll.getIncrease());
        coord = new Coord(x, y);
    }

    public Coord getCoord() {
        return coord;
    }

    public ScrollE getScroll() {
        return scroll;
    }
}
