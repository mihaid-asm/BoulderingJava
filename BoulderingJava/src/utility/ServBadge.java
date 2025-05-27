package utility;

import classes.*;

import java.util.ArrayList;
import java.util.List;

public class ServBadge {
    private static List<Badge> badges = new ArrayList<>();

    static {
        loadDefaultBadges();
    }

    public static void loadDefaultBadges() {
        badges.add(new Badge("First Route!", "You completed your first route!"));
        badges.add(new Badge("Advanced", "You completed a route of difficulty 3 or higher."));
        badges.add(new Badge("Champion", "You won a competition."));
    }

    public static Badge getBadgeByName(String name) {
        for (Badge badge : badges) {
            if (badge.getName().equalsIgnoreCase(name)) return badge;
        }
        return null;
    }

    public static void assignBadge(Climber climber, Badge badge) {
        climber.addBadge(badge);
    }

    public static List<Badge> getBadges() {
        return badges;
    }

    public static List<Badge> getBadgesByClimber(Climber climber) {
        return climber.getBadges();
    }
}