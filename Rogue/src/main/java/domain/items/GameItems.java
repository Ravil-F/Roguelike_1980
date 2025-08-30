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
        for (int i = 0; i < Common.MAX_LEVEL.getMaxLevel(); i++) {
            int countRandom = random.nextInt(4);
            switch (countRandom){
                case 0:
                    ElixirE randomElixir = ElixirE.values()[random.nextInt(ElixirE.values().length)];
                    items.add(new Elixir(randomElixir, 60, random.nextInt(MapE.WIDTH_HEIGHT.getWidth()), random.nextInt(MapE.WIDTH_HEIGHT.getWidth())));

                    break;
                case 1:
                    FoodE randomFood = FoodE.values()[random.nextInt(FoodE.values().length)];
                    items.add(new Food(randomFood, random.nextInt(MapE.WIDTH_HEIGHT.getWidth()), random.nextInt(MapE.WIDTH_HEIGHT.getWidth())));
                    break;
                case 2:
                    ScrollE randomScroll = ScrollE.values()[random.nextInt(ScrollE.values().length)];
                    items.add(new Scroll(randomScroll, random.nextInt(MapE.WIDTH_HEIGHT.getWidth()), random.nextInt(MapE.WIDTH_HEIGHT.getWidth())));
                    break;
                case 3:
                    WeaponE randomWeapon = WeaponE.values()[random.nextInt(WeaponE.values().length)];
                    items.add(new Weapon(randomWeapon, random.nextInt(MapE.WIDTH_HEIGHT.getWidth()), random.nextInt(MapE.WIDTH_HEIGHT.getWidth())));
                    break;
            }
        }
    }

    public Items getRandomItem() {
        if (items.isEmpty()) {
            return null;
        }
        int index = random.nextInt(items.size());
        return items.get(index);
    }

}
