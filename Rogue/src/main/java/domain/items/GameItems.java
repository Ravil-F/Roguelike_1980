package domain.items;

import domain.abstact.Items;
import domain.enums.*;
import domain.interfaces.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameItems implements Utils {
    private List<Items> items;
    private Random random;
    private final int countItems = 4;

    public GameItems(){
        items = new LinkedList<Items>();
        random = new Random();
        generateRandomItems();
    }

    private void generateRandomItems() {
        int tmp = CommonE.MAX_LEVEL.getMaxLevel();
        int tmpXY = MapE.WIDTH_HEIGHT.getWidth();
        for (int i = 0; i < tmp - 15; i++) {
            int countRandom = random.nextInt(0, countItems);
            switch (countRandom){
                case 0:
                    ElixirE randomElixir = ElixirE.values()[random.nextInt(0, ElixirE.values().length)];
                    items.add(new Elixir(randomElixir, 60, randomXY(tmpXY), randomXY(tmpXY)));
                    break;
                case 1:
                    FoodE randomFood = FoodE.values()[random.nextInt(0, FoodE.values().length)];
                    items.add(new Food(randomFood, randomXY(tmpXY), randomXY(tmpXY)));
                    break;
                case 2:
                    ScrollE randomScroll = ScrollE.values()[random.nextInt(0, ScrollE.values().length)];
                    items.add(new Scroll(randomScroll, randomXY(tmpXY), randomXY(tmpXY)));
                    break;
                case 3:
                    WeaponE randomWeapon = WeaponE.values()[random.nextInt(0, WeaponE.values().length)];
                    items.add(new Weapon(randomWeapon, randomXY(tmpXY), randomXY(tmpXY)));
                    break;
            }
        }
    }

    private int randomXY(int xy){
        int tmp =  random.nextInt(xy);
        if (isWithInBounds(tmp))
            return tmp;
        else return randomXY(xy);
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public boolean isWithInBounds(int x) {
        return x > 0 && x < MapE.WIDTH_HEIGHT.getWidth();
    }

    @Override
    public boolean isWithInBounds(int x, int y) {
        return false;
    }
}
