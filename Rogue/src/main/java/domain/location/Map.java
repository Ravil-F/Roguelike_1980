package domain.location;

import java.util.List;

public class Map {
    private List<Rooms> room;
    private List<Passage> passages;
    private final int width = domain.enums.Map.WIDTH_HEIGHT.getWidth();
    private final int height = domain.enums.Map.WIDTH_HEIGHT.getWidth();
    private int[][] map;
    
    public Map(){
        this.map = new int[this.width][this.height];
    }

    public String getMap(int x, int y) {
        return String.valueOf(map[x][y]);
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
