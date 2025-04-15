package Classes;

public class item {
    private String name;
    private Double cost;

    public item(String name, Double cost) {
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
