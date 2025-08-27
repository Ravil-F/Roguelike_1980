package domain;

import domain.backpack.Backpack;
import domain.common.Coord;
import domain.enums.ElixirE;
import domain.enums.FoodE;
import domain.enums.StatusE;
import domain.items.Elixir;
import domain.items.Food;
import domain.location.Map;
import domain.player.Player;

import java.util.HashMap;
import java.util.List;

public class Model {
    private Player player;
    private Backpack backpack;
    private Map map;
    private Food food;


    public Model(){
        player = new Player();
        backpack = new Backpack();
        map = new Map();
        food = new Food(FoodE.BREAD_F, 5, 6);
    }


    public void gameSession(){
        map.setMap(player.getCoord().getX(), player.getCoord().getY(), player.getSymbol());
        map.setMap(food.getCoord().getX(), food.getCoord().getY(), food.getSymbol());
    }

    public void passName(String line){
        player.setName(line);
    }

    public void movePlayer(final int status){
       int tmpX = player.getCoord().getX();
       int tmpY= player.getCoord().getY();
       if (status == StatusE.DOWN.ordinal()){
          ++tmpY;
          checkItems(tmpX, tmpY);
       }
    }

    public void checkItems(int x, int y){
        if (map.getMap(x, y) == String.valueOf(food.getSymbol())){
            player.increaseHealth(food.getIncrease());
            map.setMap(x, y, '0');
        }
    }

    //get - set metod

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

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
