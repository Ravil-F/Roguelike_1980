package domain.items;

import domain.abstact.Items;
import domain.enums.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameItems {
    private List<Items> items;
    private Random random;
    private final int countItems = 4;

    public GameItems(){
        items = new LinkedList<Items>();
        random = new Random();
        generateRandomItems();
    }

    private void generateRandomItems() {
        int tmp = Common.MAX_LEVEL.getMaxLevel();
        int tmpXY = MapE.WIDTH_HEIGHT.getWidth();
        for (int i = 0; i < tmp - 15; i++) {
            int countRandom = random.nextInt(4);
            switch (countRandom){
                case 0:
                    ElixirE randomElixir = ElixirE.values()[random.nextInt(ElixirE.values().length)];
                    items.add(new Elixir(randomElixir, 60, random.nextInt((tmpXY - 1) + 1 ), random.nextInt((tmpXY - 1) + 1)));
                    break;
                case 1:
                    FoodE randomFood = FoodE.values()[random.nextInt(FoodE.values().length)];
                    items.add(new Food(randomFood, random.nextInt((tmpXY - 1) + 1), random.nextInt((tmpXY - 1) + 1)));
                    break;
                case 2:
                    ScrollE randomScroll = ScrollE.values()[random.nextInt(ScrollE.values().length)];
                    items.add(new Scroll(randomScroll, random.nextInt((tmpXY - 1) + 1), random.nextInt((tmpXY - 1) + 1)));
                    break;
                case 3:
                    WeaponE randomWeapon = WeaponE.values()[random.nextInt(WeaponE.values().length)];
                    items.add(new Weapon(randomWeapon, random.nextInt((tmpXY - 1) + 1), random.nextInt((tmpXY - 1) + 1)));
                    break;
            }
        }
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
