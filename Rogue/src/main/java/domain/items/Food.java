package domain.items;

import domain.abstact.Items;
import domain.enums.FoodE;

public class Food extends Items {
    private FoodE food;

    public Food(FoodE food){
        super(food.getSymbol(), food.getName(), food.getIncrease());
    }

    public FoodE getFood() {
        return food;
    }
}
