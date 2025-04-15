package Classes;

public class route {
    private String name;
    private Double difficulty;
    private boulderingZone zone;

    public route(String name, Double difficulty, boulderingZone zone) {
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

    public boulderingZone getZone() {
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
