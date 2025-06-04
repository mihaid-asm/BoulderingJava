package classes;

public class Accident extends Incident {
    private Climber victim;

    public Accident(String name, String description, Zone zone, Climber victim) {
        super(name, description, zone);
        this.victim = victim;
    }

    public Climber getVictim() {
        return victim;
    }

    @Override
    public String toString() {
        return "accident{" +
                "victim=" + victim +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", zone=" + zone +
                ", solved=" + solved +
                '}';
    }
}
