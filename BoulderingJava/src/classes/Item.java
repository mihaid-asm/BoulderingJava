package classes;

public class Item {
    private String name;
    private double cost;

    public Item(String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "item{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
