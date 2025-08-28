package domain;

import domain.backpack.Backpack;
import domain.common.Coord;
import domain.enums.*;
import domain.items.Elixir;
import domain.items.Food;
import domain.location.Map;
import domain.player.Player;

import java.util.*;

public class Model {
    private List<Player> player;
    private Backpack backpack;
    private Map map;
    private Food food;


    public Model(){
        player = new LinkedList<Player>();
        player.addFirst(new Player());
        backpack = new Backpack();
        map = new Map();
        food = new Food(FoodE.BREAD_F, 5, 6);
    }


    public void gameSession(){
//        map.setMap(player.getCoord().getX(), player.getCoord().getY(), player.getSymbol());
        map = new Map();
        map.setMap(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY(), player.getFirst().getSymbol());
        map.setMap(food.getCoord().getX(), food.getCoord().getY(), food.getSymbol());
    }

    public void passName(String line){
        player.getFirst().setName(line);
    }

    public void movePlayer(final int status){
       int tmpX = player.getFirst().getCoord().getX();
       int tmpY= player.getFirst().getCoord().getY();

       if (status == StatusE.UP.ordinal()){
          --tmpY;
          if (tmpY > 0) {
              checkItems(tmpX, tmpY);
              addPlayer(tmpX, tmpY);
          }
       }

        if (status == StatusE.DOWN.ordinal()){
            ++tmpY;
            if (tmpY < MapE.WIDTH_HEIGHT.ordinal()) {
                checkItems(tmpX, tmpY);
                addPlayer(tmpX, tmpY);
            }
        }

        if (status == StatusE.LEFT.ordinal()){
            --tmpX;
            if (tmpX > 0) {
                checkItems(tmpX, tmpY);
                addPlayer(tmpX, tmpY);
            }
        }

        if (status == StatusE.RIGHT.ordinal()){
            ++tmpX;
            if (tmpY < MapE.WIDTH_HEIGHT.ordinal()) {
                checkItems(tmpX, tmpY);
                addPlayer(tmpX, tmpY);
            }
        }


    }

    public void checkItems(int x, int y){
        if (map.getMap(x, y) == String.valueOf(food.getSymbol())) {
            player.getFirst().increaseHealth(food.getIncrease());
            addPlayer(x, y);
        }
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

//    public void setPlayer(Player player) {
//        this.player.getFirst() = player;
//    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
