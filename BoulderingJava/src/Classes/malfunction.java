package Classes;

public class malfunction extends incident {
    private route brokenRoute;

    public malfunction(String name, String description, boulderingZone zone, route brokenRoute) {
        super(name, description, zone);
        this.brokenRoute = brokenRoute;
    }

    public route getBrokenRoute() {
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
