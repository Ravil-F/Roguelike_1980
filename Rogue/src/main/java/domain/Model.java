package domain;

import domain.location.Map;
import domain.player.Player;

public class Model {
    private Player player;
    private Map map;

    public Model(){
        player = new Player();
        map = new Map();
    }


    public void gameSession(String line){
        player.setName(line);
        map.setMap(player.getCoord().getX(), player.getCoord().getY(), player.getSymbol());
    }




    //get - set metod

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
