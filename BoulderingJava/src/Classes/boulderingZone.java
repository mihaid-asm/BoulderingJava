package Classes;

public class boulderingZone {
    private String name;

    public boulderingZone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "boulderingZone{" +
                "name='" + name + '\'' +
                '}';
    }
}
