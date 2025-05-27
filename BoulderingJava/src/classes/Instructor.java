package classes;

public class Instructor {
    private String name;
    private Zone zone;

    public Instructor(String name, Zone zone) {
        this.name = name;
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public Zone getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return "instructor{" +
                "name='" + name + '\'' +
                ", zone=" + zone +
                '}';
    }
}
