package domain;

import domain.abstact.Items;
import domain.backpack.Backpack;
import domain.enums.*;
import domain.items.Food;
import domain.location.Map;
import domain.player.Player;

import java.util.*;

public class Model {
    private List<Player> player;
    private Backpack backpack;
    private Map map;
    private List<Items> items;
//    private Food food;


    public Model(){
        player = new LinkedList<Player>();
        player.addFirst(new Player());

        backpack = new Backpack();
        backpack.add(new Food(FoodE.BREAD_F, 5, 6 ));
        map = new Map();

        items = new LinkedList<Items>();
        items.add(new Food(FoodE.BREAD_F, 5, 3));
    }

    public void gameInitialization(){
        map.setMap(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY(), player.getFirst().getSymbol());
        map.setMap(items.getFirst().getCoord().getX(), items.getFirst().getCoord().getY(), items.getFirst().getSymbol());
    }

    public void gameSession(){
        map.setMap(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY(), player.getFirst().getSymbol());
    }

    public void passName(String line){
        player.getFirst().setName(line);
    }

    public void movePlayer(final int status) {
        int tmpX = player.getFirst().getCoord().getX();
        int tmpY = player.getFirst().getCoord().getY();

        switch (status) {
            case 0:
                if (tryMove(tmpX, ++tmpY)) {
                    map.removeItemNull(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY());
                }
                break;

            case 1:
                if (tryMove(tmpX, --tmpY)) {
                    map.removeItemNull(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY());
                }
                break;

            case 2:
                if (tryMove(--tmpX, tmpY)) {
                    map.removeItemNull(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY());
                }
                break;

            case 3:
                if (tryMove(++tmpX, tmpY)) {
                    map.removeItemNull(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY());
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid status");
        }

        addPlayer(tmpX, tmpY);
    }

    private boolean tryMove(int x, int y) {
        if (isWithinBounds(x, y) && !checkItems(x, y)) {
            return true;
        }
        return false;
    }

    private boolean isWithinBounds(int x, int y) {
        return x > 0 && y > 0 && x < MapE.WIDTH_HEIGHT.getWidth() && y < MapE.WIDTH_HEIGHT.getWidth();
    }


    public boolean checkItems(int x, int y){
        if (map.convertIntToString(x, y).equals(String.valueOf(items.getFirst().getSymbol()))) {
            player.getFirst().increaseHealth(items.getFirst().getIncrease());
            backpack.add(items.getFirst());
            items.removeLast();
            map.removeItemNull(x, y);
            return true;
        }
        return false;
    }

    private void addPlayer(int x, int y){
        player.addFirst(new Player(player.getFirst().getName(),
                player.getFirst().getSymbol(),
                player.getFirst().getColor(),
                player.getFirst().getMaxHealth(),
                player.getFirst().getHealth(),
                player.getFirst().getAgility(),
                player.getFirst().getStrength(),
                x, y));
        player.removeLast();
    }

    //get - set metod
    public Player getPlayer() {
        return player.getFirst();
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
