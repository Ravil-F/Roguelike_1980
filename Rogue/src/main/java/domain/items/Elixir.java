package domain.items;

import domain.abstact.Items;
import domain.enums.ElixirE;

public class Elixir extends Items {
    private ElixirE elixir;
    private final int duration;

    public Elixir(ElixirE elixir, int duration){
        super(elixir.getSymbol(), elixir.getName(), elixir.getIncrease());
        this.duration = duration;
    }

    public ElixirE getElixir() {
        return elixir;
    }

    public int getDuration() {
        return duration;
    }
}
