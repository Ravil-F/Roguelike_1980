package domain.location;

import domain.enums.MapE;

import java.util.List;

public class Map {
    private List<Rooms> room;
    private List<Passage> passages;
    private final int width = MapE.WIDTH_HEIGHT.getWidth();
    private final int height = MapE.WIDTH_HEIGHT.getWidth();
    private int[][] map;
    
    public Map(){
        this.map = new int[this.width][this.height];
    }

    public String convertIntToString(int x, int y){
        String tmpstr =  getMap(x, y);
        int tmpint = Integer.parseInt(tmpstr);
        char tmpch = (char)tmpint;
        return String.valueOf(tmpch);
    }

    public void removeItemNull(int x, int y) {
        if (isWithinBounds(x, y)) {
            map[x][y] = '0';
        }
    }

    private boolean isWithinBounds(int x, int y) {
        return x > 0 && y > 0 && x < MapE.WIDTH_HEIGHT.getWidth() && y < MapE.WIDTH_HEIGHT.getWidth();
    }

    public String getMap(int x, int y) {
        return String.valueOf(map[x][y]);
    }

    public int getMapChar(int x, int y) {
        return map[x][y];
    }

    public void setMap(int x, int y, int value) {
        this.map[x][y] = value;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
