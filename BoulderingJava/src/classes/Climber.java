package classes;

import java.util.*;

import interfaces.Persistence;
import utility.Pair;

public class Climber implements Persistence {
    private int id;
    private String name;
    private Date registrationDate;
    private List<Pair<Route, Integer>> climbedRoutes;
    private List<Badge> badges;
    private Map<Item, Integer> purchases;

    public Climber(int id, String name) {
        this.id = id;
        this.name = name;
        this.registrationDate = new Date();
        this.climbedRoutes = new ArrayList<>();
        this.badges = new ArrayList<>();
        this.purchases = new HashMap<>();
    }

    public Climber() {

    }

    public Climber(int cid, String cname, String cdate) {
        this.id = cid;
        this.name = cname;
        this.registrationDate = new Date();
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public List<Pair<Route, Integer>> getClimbedRoutes() {
        return climbedRoutes;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void climberCompletesRoute(Route r, int timeInSeconds) {
        Pair<Route, Integer> completion = new Pair<>(r, timeInSeconds);

        for (Pair<Route, Integer> cr : this.getClimbedRoutes()) {
            if (cr.getKey().equals(r) && timeInSeconds >= cr.getValue()) {
                System.out.println("Climber " + this.getName() + " has already completed this route.");
                return;
            }
        }

        this.getClimbedRoutes().add(completion);
        System.out.println("Climber " + this.getName() + " completed route '" + r.getName() + "' in " + timeInSeconds + " seconds.");
    }

    public void buyItem(Item item) {
        if (purchases.containsKey(item)) {
            purchases.put(item, purchases.get(item) + 1);
        }
        else {
            purchases.put(item, 1);
        }
    }

    public Boolean hasBadge(Badge badge) {
        return this.getBadges().contains(badge);
    }

    public void addBadge(Badge badge) {
        if(this.hasBadge(badge)) {
            System.out.println("Badge " + this.getName() + " is already in the list.");
            return;
        }
        this.badges.add(badge);
    }

    @Override
    public String toString() {
        return "climber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", climbedRoutes=" + climbedRoutes +
                ", badges=" + badges +
                ", purchases=" + purchases +
                '}';
    }

    @Override
    public String tableName() {
        return "Climbers";
    }

    @Override
    public Vector<Pair<String, String>> tableColumns() {
        Vector<Pair<String, String>> cols = new Vector<>();
        cols.add(new Pair<>("name", "VARCHAR(100)"));
        return cols;
    }

    @Override
    public Vector<String> tableValues() {
        Vector<String> values = new Vector<>();
        values.add(name);
        return values;
    }

    @Override
    public int pk() {
        return id;
    }
}
