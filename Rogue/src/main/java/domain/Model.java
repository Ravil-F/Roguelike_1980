package domain;

import domain.utils.Utils;
import domain.backpack.Backpack;
import domain.items.GameItems;
import domain.location.Map;
import domain.player.Player;

import java.util.*;

public class Model {
    private List<Player> player;
    private Backpack backpack;
    private Map map;
    private GameItems items;
    private Utils utils;

    public Model(){
        player = new LinkedList<Player>();
        player.addFirst(new Player());
        backpack = new Backpack();
        map = new Map();
        items = new GameItems();
        utils = new Utils();
    }

    public void gameInitialization(){
        map.setMap(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY(), player.getFirst().getSymbol());

        for(int i = 0; i < items.getItems().size(); ++i) {
            map.setMap(items.getItems().get(i).getCoord().getX(), items.getItems().get(i).getCoord().getY(), items.getItems().get(i).getSymbol());
        }
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
        int oldX = tmpX;
        int oldY = tmpY;

        switch (status) {
            case 0:
                ++tmpY;
                break;
            case 1:
                --tmpY;
                break;
            case 2:
                --tmpX;
                break;
            case 3:
                ++tmpX;
                break;
            default:
                throw new IllegalArgumentException("Invalid status");
        }

        if (tryMove(tmpX, tmpY)) {
            map.putZero(oldX, oldY);
            map.putZero(tmpX, tmpY);
            addPlayer(tmpX, tmpY);
        }
    }

    private boolean tryMove(int x, int y) {
        if (utils.isWithinBounds(x, y) && !checkItems(x, y)) {
            return true;
        }
        return false;
    }

    public boolean checkItems(int x, int y){
        if(items.getItems() == null) return false;
        int index = equalsMapItems(x, y, items);
        if (index != -1) {
            System.out.println("items: " + items.getItems().get(index));
            backpack.add(items.getItems().get(index));
            backpack.printBackpack();
            map.putZero(x, y);
            map.putZero(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY());
            addPlayer(x, y);
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

    private int equalsMapItems(int x, int y, GameItems items){
        for(int i = 0; i < items.getItems().size(); i++){
            if (map.convertIntToString(x, y).equals(String.valueOf(items.getItems().get(i).getSymbol())))
                return i;
        }
        return -1;
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

}
