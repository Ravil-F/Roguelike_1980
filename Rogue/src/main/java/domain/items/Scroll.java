package domain.items;

import domain.abstact.Items;
import domain.enums.ScrollE;

public class Scroll extends Items {
    private ScrollE scroll;

    public Scroll(ScrollE scroll){
        super(scroll.getSymbol(), scroll.getName(), scroll.getIncrease());
    }
}
