package Utility;

import Classes.*;

import java.util.*;

public class Service {
    private static List<Climber> registeredClimbers;
    private static List<Route> registeredRoutes;
    private static List<Instructor> registeredInstructors;
    private static List<Zone> registeredBoulderingZones;
    private static List<Item> registeredItems;
    private static List<Incident> registeredIncidents;
    private static List<Badge> registeredBadges;
    private static List<Competition> registeredCompetitions;

    public Service() {
        this.registeredClimbers = new ArrayList<>();
        this.registeredRoutes = new ArrayList<>();
        this.registeredInstructors = new ArrayList<>();
        this.registeredBoulderingZones = new ArrayList<>();
        this.registeredItems = new ArrayList<>();
        this.registeredIncidents = new ArrayList<>();
        this.registeredBadges = new ArrayList<>();
        this.registeredCompetitions = new ArrayList<>();
        loadDefaultBadges();
    }

    public static List<Climber> getRegisteredClimbers() {
        return registeredClimbers;
    }

    public static List<Route> getRegisteredRoutes() {
        return registeredRoutes;
    }

    public static List<Instructor> getRegisteredInstructors() {
        return registeredInstructors;
    }

    public static List<Zone> getRegisteredBoulderingZones() {
        return registeredBoulderingZones;
    }

    public static List<Item> getRegisteredItems() {
        return registeredItems;
    }

    public static List<Incident> getRegisteredIncidents() {
        return registeredIncidents;
    }

    public static void loadDefaultBadges() {
        registeredBadges.add(new Badge("First Route!", "You completed your first route!"));
        registeredBadges.add(new Badge("Advanced", "You completed a route of difficulty 3 or higher."));
        registeredBadges.add(new Badge("Champion", "You won a competition."));
    }

    public static Climber getClimberByName(String name) {
        for (Climber climber : registeredClimbers) {
            if (climber.getName().equals(name)) {
                return climber;
            }
        }
        return null;
    }

    public static Route getRouteByName(String name) {
        for (Route route : registeredRoutes) {
            if (route.getName().equals(name)) {
                return route;
            }
        }
        return null;
    }

    public static Instructor getInstructorByName(String name) {
        for (Instructor instructor : registeredInstructors) {
            if (instructor.getName().equals(name)) {
                return instructor;
            }
        }
        return null;
    }

    public static Zone getBoulderingZoneByName(String name) {
        for (Zone boulderingZone : registeredBoulderingZones) {
            if (boulderingZone.getName().equals(name)) {
                return boulderingZone;
            }
        }
        return null;
    }

    public static Item getItemByName(String name) {
        for (Item item : registeredItems) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public static Incident getIncidentByName(String name) {
        for (Incident incident : registeredIncidents) {
            if (incident.getName().equals(name)) {
                return incident;
            }
        }
        return null;
    }

    public static Competition getCompetitionByName(String name) {
        for (Competition competition : registeredCompetitions) {
            if (competition.getName().equals(name)) {
                return competition;
            }
        }
        return null;
    }

    public static Badge getBadgeByName(String name) {
        for (Badge b : registeredBadges) {
            if (b.getName().equalsIgnoreCase(name)) {
                return b;
            }
        }
        return null;
    }

    public List<Badge> getBadgesByClimber(Climber climber) {
        return climber.getBadges();
    }

    public static void assignBadge(Climber climber, Badge badge) {
        climber.addBadge(badge);
    }

    public static List<Competition> getRegisteredCompetitions() {
        return registeredCompetitions;
    }

    public static Climber registerClimber(String name) {
        Climber newClimber = new Climber(name);
        registeredClimbers.add(newClimber);
        System.out.println("Climber '" + name + "' registered on " + newClimber.getRegistrationDate());
        return newClimber;
    }

    public static void completeRoute(Climber climber, Route route, Integer timeInSeconds) {
        climber.climberCompletesRoute(route, timeInSeconds);
        System.out.println(climber.getName() + " completed route " + route + ".");

        assignBadge(climber, getBadgeByName("First Route!"));

        if(route.getDifficulty() >= 3){
            assignBadge(climber, getBadgeByName("Advanced"));
        }
    }

    public static Instructor hireInstructor(String name, Zone zone) {
        Instructor newInstructor = new Instructor(name, zone);
        registeredInstructors.add(newInstructor);
        System.out.println("Instructor '" + name + "' hired.");
        return newInstructor;
    }

    public static Zone createZone(String name) {
        Zone newZone = new Zone(name);
        registeredBoulderingZones.add(newZone);
        System.out.println("Zone '" + name + "' created.");
        return newZone;
    }

    public static Route createRoute(String name, Double difficulty, Zone zone) {
        Route newRoute = new Route(name, difficulty, zone);
        registeredRoutes.add(newRoute);
        System.out.println("Route '" + name + "' created on zone '" + zone.getName() + "'. Difficulty: " + difficulty);
        return newRoute;
    }

    public static Item addItem(String name, Double cost) {
        Item newItem = new Item(name, cost);
        registeredItems.add(newItem);
        System.out.println("Item '" + name + "' added. Cost: $" + cost + ".");
        return newItem;
    }

    public static void climberBuysAnItem(Climber climber, Item item) {
        climber.buyItem(item);
        System.out.println("Climber '" + climber.getName() + "' bought " + item.getName() + ".");
    }

    public static Competition startCompetition(String name) {
        Competition newCompetition = new Competition(name);
        registeredCompetitions.add(newCompetition);
        System.out.println("Competition '" + name + "' started.");
        return newCompetition;
    }

    public static void climberRegistersToCompetition(Climber climber, Competition competition, Integer score) {
        competition.addResult(climber, score);
        System.out.println("Climber '" + climber.getName() + "' registered to competition " + competition.getName() + ".");
    }

    public static void closeCompetitionRegistration(Competition competition) {
        competition.closeCompetition();
        System.out.println("Competition '" + competition.getName() + "' closed.");

        Set<Pair<Climber, Integer>> leaderboard = competition.getLeaderboard();

        if (!leaderboard.isEmpty()) {
            Pair<Climber, Integer> winnerEntry = leaderboard.iterator().next();
            assignBadge(winnerEntry.getKey(), getBadgeByName("Champion"));
        }
    }

    public static void showCompetition(Competition competition) {
        competition.printLeaderboard();
    }

    public static Incident reportIncident(Incident incident) {
        registeredIncidents.add(incident);
        System.out.println("Reported incident: " + incident.getName());
        return incident;
    }

    public static void solveIncident(Incident incident) {
        incident.markAsSolved();
    }

    public static void showUnsolvedMalfunctions() {
        Integer i = 1;
        for(Incident incident : registeredIncidents) {
            if(incident instanceof Malfunction && !incident.isSolved()) {
                System.out.println(i.toString() + ". " + incident.getName());
                i++;
            }
        }
    }
}
