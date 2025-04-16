package Classes;

public class instructor {
    private String name;
    private boulderingZone zone;

    public instructor(String name, boulderingZone zone) {
        this.name = name;
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public boulderingZone getZone() {
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
