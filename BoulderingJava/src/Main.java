import Classes.*;
import Utility.service;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        service boulderingJava = new service();

        boulderingJava.registerClimber("Mihai");
        boulderingJava.registerClimber("Vlad");
        boulderingJava.registerClimber("Cristi");

        climber mihai = boulderingJava.getClimberByName("Mihai");

        boulderingJava.createZone("Natural High");

        boulderingZone natHigh = boulderingJava.getBoulderingZoneByName("Natural High");

        boulderingJava.createRoute("Tutorial", 1.0, natHigh);
        boulderingJava.createRoute("Ball Climb", 2.2, natHigh);
        boulderingJava.createRoute("Steep Steps", 3.5, natHigh);

        boulderingJava.hireInstructor("Matei", natHigh);

        accident accident = new accident("Leg", "leg broke", natHigh, boulderingJava.getClimberByName("Cristi"));
        boulderingJava.reportIncident(accident);
        malfunction malfunction = new malfunction("Part", "finish part broke", natHigh, boulderingJava.getRouteByName("Steep Steps"));
        boulderingJava.reportIncident(malfunction);
        boulderingJava.showUnsolvedMalfunctions();
        boulderingJava.solveIncident(boulderingJava.getIncidentByName("Part"));
        boulderingJava.showUnsolvedMalfunctions();

        boulderingJava.startCompetition("Natural Olympics");
        competition natOlymp = boulderingJava.getCompetitionByName("Natural Olympics");
        boulderingJava.climberRegistersToCompetition(boulderingJava.getClimberByName("Mihai"), natOlymp, 55);
        boulderingJava.climberRegistersToCompetition(boulderingJava.getClimberByName("Vlad"), natOlymp, 50);

        boulderingJava.closeCompetitionRegistration(natOlymp);

        boulderingJava.showCompetition(natOlymp);

        List<badge> mihaiBadge = boulderingJava.getBadgesByClimber(boulderingJava.getClimberByName("Mihai"));
        System.out.println(mihaiBadge);

        boulderingJava.addItem("Bouldering Boots", 59.99);
        item boots = boulderingJava.getItemByName("Bouldering Boots");
        for(int i = 0; i < 5; i++)
            boulderingJava.climberBuysAnItem(mihai, boots);

        boulderingJava.completeRoute(mihai, boulderingJava.getRouteByName("Steep Steps"), 35);

        System.out.println(service.getRegisteredClimbers());
    }
}