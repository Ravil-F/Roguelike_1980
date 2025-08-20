package domain.items;

import domain.abstact.Items;
import domain.common.Coord;
import domain.enums.FoodE;

public class Food extends Items {
    private FoodE food;
    private final Coord coord;

    public Food(FoodE food, int x, int y){
        super(food.getSymbol(), food.getName(), food.getIncrease());
        coord = new Coord(x, y);
    }

    public FoodE getFood() {
        return food;
    }

    public Coord getCoord() {
        return coord;
    }
}
