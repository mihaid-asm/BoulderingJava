import Classes.*;
import Utility.Service;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service boulderingJava = new Service();

        boulderingJava.registerClimber("Mihai");
        boulderingJava.registerClimber("Vlad");
        boulderingJava.registerClimber("Cristi");

        Climber mihai = boulderingJava.getClimberByName("Mihai");

        boulderingJava.createZone("Natural High");

        Zone natHigh = boulderingJava.getBoulderingZoneByName("Natural High");

        boulderingJava.createRoute("Tutorial", 1.0, natHigh);
        boulderingJava.createRoute("Ball Climb", 2.2, natHigh);
        boulderingJava.createRoute("Steep Steps", 3.5, natHigh);

        boulderingJava.hireInstructor("Matei", natHigh);

        Accident accident = new Accident("Leg", "leg broke", natHigh, boulderingJava.getClimberByName("Cristi"));
        boulderingJava.reportIncident(accident);
        Malfunction malfunction = new Malfunction("Part", "finish part broke", natHigh, boulderingJava.getRouteByName("Steep Steps"));
        boulderingJava.reportIncident(malfunction);
        boulderingJava.showUnsolvedMalfunctions();
        boulderingJava.solveIncident(boulderingJava.getIncidentByName("Part"));
        boulderingJava.showUnsolvedMalfunctions();

        boulderingJava.startCompetition("Natural Olympics");
        Competition natOlymp = boulderingJava.getCompetitionByName("Natural Olympics");
        boulderingJava.climberRegistersToCompetition(boulderingJava.getClimberByName("Mihai"), natOlymp, 55);
        boulderingJava.climberRegistersToCompetition(boulderingJava.getClimberByName("Vlad"), natOlymp, 50);

        boulderingJava.closeCompetitionRegistration(natOlymp);

        boulderingJava.showCompetition(natOlymp);

        List<Badge> mihaiBadge = boulderingJava.getBadgesByClimber(boulderingJava.getClimberByName("Mihai"));
        System.out.println(mihaiBadge);

        boulderingJava.addItem("Bouldering Boots", 59.99);
        Item boots = boulderingJava.getItemByName("Bouldering Boots");
        for(int i = 0; i < 5; i++)
            boulderingJava.climberBuysAnItem(mihai, boots);

        boulderingJava.completeRoute(mihai, boulderingJava.getRouteByName("Steep Steps"), 35);

        System.out.println(Service.getRegisteredClimbers());
    }
}