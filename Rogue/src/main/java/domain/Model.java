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

    }


    public void gameSession(){
        map = new Map();
        map.setMap(player.getFirst().getCoord().getX(), player.getFirst().getCoord().getY(), player.getFirst().getSymbol());
        map.setMap(backpack.getItems().getCoord().getX(), backpack.getItems().getCoord().getY(), backpack.getItems().getSymbol());
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
            if (tmpY < MapE.WIDTH_HEIGHT.getWidth()) {
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
            if (tmpY < MapE.WIDTH_HEIGHT.getWidth()) {
                checkItems(tmpX, tmpY);
                addPlayer(tmpX, tmpY);
            }
        }
    }

    public void checkItems(int x, int y){
        if (map.getMap(x, y) == String.valueOf(backpack.getItems().getSymbol())) {
            player.getFirst().increaseHealth(backpack.getItems().getIncrease());
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
