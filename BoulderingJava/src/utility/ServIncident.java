package utility;

import classes.*;

import java.util.ArrayList;
import java.util.List;

public class ServIncident {
    private static List<Incident> incidents = new ArrayList<>();

    public static Incident reportIncident(Incident incident) {
        incidents.add(incident);
        System.out.println("Reported incident: " + incident.getName());
        Logs.log("Reported incident: " + incident.getName());
        return incident;
    }

    public static void solveIncident(Incident incident) {
        Logs.log(incident.getName() + "has been solved");
        incident.markAsSolved();
    }

    public static List<Incident> getIncidents() {
        return incidents;
    }

    public static Incident getIncidentByName(String name) {
        for (Incident incident : incidents) {
            if (incident.getName().equals(name)) return incident;
        }
        return null;
    }

    public static void showUnsolvedMalfunctions() {
        int i = 1;
        for (Incident incident : incidents) {
            if (incident instanceof Malfunction && !incident.isSolved()) {
                System.out.println(i + ". " + incident.getName());
                i++;
            }
        }
        Logs.log("Unsolved malfunctions shown");
    }
}