package Classes;

import Utility.Pair;

import java.util.Date;

public class incident {
    public String name;
    public String description;
    public Date time;
    public boulderingZone zone;
    public Boolean solved = false;

    public incident(String name, String description, boulderingZone zone) {
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

    public boulderingZone getZone() {
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
