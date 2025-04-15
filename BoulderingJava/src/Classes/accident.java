package Classes;

public class accident extends incident {
    private climber victim;

    public accident(String name, String description, boulderingZone zone, climber victim) {
        super(name, description, zone);
        this.victim = victim;
    }

    public climber getVictim() {
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
