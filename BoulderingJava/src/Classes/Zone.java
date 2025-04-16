package Classes;

public class Zone {
    private String name;

    public Zone(String name) {
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
