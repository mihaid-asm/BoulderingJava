package utility;

import classes.*;

import java.util.ArrayList;
import java.util.List;

public class ServClimber {
    private static List<Climber> climbers = new ArrayList<>();

    public static Climber registerClimber(String name) {
        Climber climber = new Climber(name);
        climbers.add(climber);
        System.out.println("Climber '" + name + "' registered on " + climber.getRegistrationDate());
        return climber;
    }

    public static Climber getClimberByName(String name) {
        for (Climber climber : climbers) {
            if (climber.getName().equals(name)) return climber;
        }
        return null;
    }

    public static List<Climber> getClimbers() {
        return climbers;
    }

    public static void completeRoute(Climber climber, Route route, int timeInSeconds) {
        climber.climberCompletesRoute(route, timeInSeconds);
        System.out.println(climber.getName() + " completed route " + route.getName() + ".");

        ServBadge.assignBadge(climber, ServBadge.getBadgeByName("First Route!"));
        if (route.getDifficulty() >= 3) {
            ServBadge.assignBadge(climber, ServBadge.getBadgeByName("Advanced"));
        }
    }

    public static void climberBuysAnItem(Climber climber, Item item) {
        climber.buyItem(item);
        System.out.println("Climber '" + climber.getName() + "' bought " + item.getName() + ".");
    }
}