package domain.backpack;

import java.util.ArrayList;
import java.util.List;
import domain.abstact.Items;

public class Backpack {
    private List<Items> items;
    private int counter;

    public Backpack() {
        items = new ArrayList<>();
        this.counter = 0;
    }

    public Items getItems(){
        return items.get(0);
    }

    public String getItemsName(){
        return items.get(0).getName();
    }

    public char getItemsSymbol(){
        return items.get(0).getSymbol();
    }

    public int getItemsIncrease(){
        return items.get(0).getIncrease();
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void add(Items item){
        this.items.add(item);
        ++counter;
    }
}
