package Classes;

import java.util.*;

import Utility.Pair;

public class climber {
    private String name;
    private Date registrationDate;
    private List<Pair<route, Integer>> climbedRoutes; //the int is completion time(sec)
    private List<badge> badges;
    private Map<item, Integer> purchases;

    public climber(String name) {
        this.name = name;
        this.registrationDate = new Date();
        this.climbedRoutes = new ArrayList<>();
        this.badges = new ArrayList<>();
        this.purchases = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public List<Pair<route, Integer>> getClimbedRoutes() {
        return climbedRoutes;
    }

    public List<badge> getBadges() {
        return badges;
    }

    public void climberCompletesRoute(route r, int timeInSeconds) {
        Pair<route, Integer> completion = new Pair<>(r, timeInSeconds);

        for (Pair<route, Integer> cr : this.getClimbedRoutes()) {
            if (cr.getKey().equals(r) && timeInSeconds >= cr.getValue()) {
                System.out.println("Climber " + this.getName() + " has already completed this route.");
                return;
            }
        }

        this.getClimbedRoutes().add(completion);
        System.out.println("Climber " + this.getName() + " completed route '" + r.getName() + "' in " + timeInSeconds + " seconds.");
    }

    public void buyItem(item item) {
        if (purchases.containsKey(item)) {
            purchases.put(item, purchases.get(item) + 1);
        }
        else {
            purchases.put(item, 1);
        }
    }

    public Boolean hasBadge(badge badge) {
        return this.getBadges().contains(badge);
    }

    public void addBadge(badge badge) {
        if(this.hasBadge(badge)) {
            System.out.println("Badge " + this.getName() + " is already in the list.");
            return;
        }
        this.badges.add(badge);
    }

    @Override
    public String toString() {
        return "climber{" +
                "name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", climbedRoutes=" + climbedRoutes +
                ", badges=" + badges +
                ", purchases=" + purchases +
                '}';
    }
}
