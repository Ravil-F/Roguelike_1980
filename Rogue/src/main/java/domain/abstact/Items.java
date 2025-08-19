package domain.abstact;

public abstract class Items {
    private final String name;
    private  final int increase;

    public Items(String name, int increase) {
        this.name = name;
        this.increase = increase;
    }

    public String getName() {
        return name;
    }

    public int getIncrease() {
        return increase;
    }
}
