package classes;

public class Malfunction extends Incident {
    private Route brokenRoute;

    public Malfunction(String name, String description, Zone zone, Route brokenRoute) {
        super(name, description, zone);
        this.brokenRoute = brokenRoute;
    }

    public Route getBrokenRoute() {
        return brokenRoute;
    }

    @Override
    public String toString() {
        return "malfunction{" +
                "brokenRoute=" + brokenRoute +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", zone=" + zone +
                ", solved=" + solved +
                '}';
    }
}
