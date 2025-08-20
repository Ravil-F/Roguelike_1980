package domain.items;

import domain.abstact.Items;
import domain.common.Coord;
import domain.enums.ElixirE;

public class Elixir extends Items {
    private ElixirE elixir;
    private final Coord coord;
    private final int duration;

    public Elixir(ElixirE elixir, int duration, int x, int y){
        super(elixir.getSymbol(), elixir.getName(), elixir.getIncrease());
        this.duration = duration;
        coord = new Coord(x, y);
    }

    public ElixirE getElixir() {
        return elixir;
    }

    public int getDuration() {
        return duration;
    }

    public Coord getCoord() {
        return coord;
    }
}
