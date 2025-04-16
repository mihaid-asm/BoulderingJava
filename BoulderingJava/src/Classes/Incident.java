package Classes;

import java.util.Date;

public class Incident {
    public String name;
    public String description;
    public Date time;
    public Zone zone;
    public Boolean solved = false;

    public Incident(String name, String description, Zone zone) {
        this.name = name;
        this.description = description;
        this.zone = zone;
        this.time = new Date();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getTime() {
        return time;
    }

    public Zone getZone() {
        return zone;
    }

    public boolean isSolved() {
        return solved;
    }

    public void markAsSolved() {
        if (!solved) {
            this.solved = true;
            System.out.println("Incident '" + name + "' marked as solved.");
        } else {
            System.out.println("Incident '" + name + "' is already solved and cannot be changed.");
        }
    }



    @Override
    public String toString() {
        return "incident{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", zone=" + zone +
                '}';
    }
}
