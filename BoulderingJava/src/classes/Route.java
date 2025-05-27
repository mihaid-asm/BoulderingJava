package classes;

public class Route {
    private String name;
    private double difficulty;
    private Zone zone;

    public Route(String name, Double difficulty, Zone zone) {
        this.name = name;
        this.difficulty = difficulty;
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public Zone getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return "BoulderingRoute{" +
                "name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", zone=" + zone.getName() +
                '}';
    }
}
