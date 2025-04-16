package Utility;

import Classes.*;

import java.util.*;

public class service {
    private static List<climber> registeredClimbers;
    private static List<route> registeredRoutes;
    private static List<instructor> registeredInstructors;
    private static List<boulderingZone> registeredBoulderingZones;
    private static List<item> registeredItems;
    private static List<incident> registeredIncidents;
    private static List<badge> registeredBadges;
    private static List<competition> registeredCompetitions;

    public service() {
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

    public static List<climber> getRegisteredClimbers() {
        return registeredClimbers;
    }

    public static List<route> getRegisteredRoutes() {
        return registeredRoutes;
    }

    public static List<instructor> getRegisteredInstructors() {
        return registeredInstructors;
    }

    public static List<boulderingZone> getRegisteredBoulderingZones() {
        return registeredBoulderingZones;
    }

    public static List<item> getRegisteredItems() {
        return registeredItems;
    }

    public static List<incident> getRegisteredIncidents() {
        return registeredIncidents;
    }

    public static void loadDefaultBadges() {
        registeredBadges.add(new badge("First Route!", "You completed your first route!"));
        registeredBadges.add(new badge("Advanced", "You completed a route of difficulty 3 or higher."));
        registeredBadges.add(new badge("Champion", "You won a competition."));
    }

    public static climber getClimberByName(String name) {
        for (climber climber : registeredClimbers) {
            if (climber.getName().equals(name)) {
                return climber;
            }
        }
        return null;
    }

    public static route getRouteByName(String name) {
        for (route route : registeredRoutes) {
            if (route.getName().equals(name)) {
                return route;
            }
        }
        return null;
    }

    public static instructor getInstructorByName(String name) {
        for (instructor instructor : registeredInstructors) {
            if (instructor.getName().equals(name)) {
                return instructor;
            }
        }
        return null;
    }

    public static boulderingZone getBoulderingZoneByName(String name) {
        for (boulderingZone boulderingZone : registeredBoulderingZones) {
            if (boulderingZone.getName().equals(name)) {
                return boulderingZone;
            }
        }
        return null;
    }

    public static item getItemByName(String name) {
        for (item item : registeredItems) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public static incident getIncidentByName(String name) {
        for (incident incident : registeredIncidents) {
            if (incident.getName().equals(name)) {
                return incident;
            }
        }
        return null;
    }

    public static competition getCompetitionByName(String name) {
        for (competition competition : registeredCompetitions) {
            if (competition.getName().equals(name)) {
                return competition;
            }
        }
        return null;
    }

    public static badge getBadgeByName(String name) {
        for (badge b : registeredBadges) {
            if (b.getName().equalsIgnoreCase(name)) {
                return b;
            }
        }
        return null;
    }

    public List<badge> getBadgesByClimber(climber climber) {
        return climber.getBadges();
    }

    public static void assignBadge(climber climber, badge badge) {
        climber.addBadge(badge);
    }

    public static List<competition> getRegisteredCompetitions() {
        return registeredCompetitions;
    }

    public static climber registerClimber(String name) {
        climber newClimber = new climber(name);
        registeredClimbers.add(newClimber);
        System.out.println("Climber '" + name + "' registered on " + newClimber.getRegistrationDate());
        return newClimber;
    }

    public static void completeRoute(climber climber, route route, Integer timeInSeconds) {
        climber.climberCompletesRoute(route, timeInSeconds);
        System.out.println(climber.getName() + " completed route " + route + ".");

        assignBadge(climber, getBadgeByName("First Route!"));

        if(route.getDifficulty() >= 3){
            assignBadge(climber, getBadgeByName("Advanced"));
        }
    }

    public static instructor hireInstructor(String name, boulderingZone zone) {
        instructor newInstructor = new instructor(name, zone);
        registeredInstructors.add(newInstructor);
        System.out.println("Instructor '" + name + "' hired.");
        return newInstructor;
    }

    public static boulderingZone createZone(String name) {
        boulderingZone newZone = new boulderingZone(name);
        registeredBoulderingZones.add(newZone);
        System.out.println("Zone '" + name + "' created.");
        return newZone;
    }

    public static route createRoute(String name, Double difficulty, boulderingZone zone) {
        route newRoute = new route(name, difficulty, zone);
        registeredRoutes.add(newRoute);
        System.out.println("Route '" + name + "' created on zone '" + zone.getName() + "'. Difficulty: " + difficulty);
        return newRoute;
    }

    public static item addItem(String name, Double cost) {
        item newItem = new item(name, cost);
        registeredItems.add(newItem);
        System.out.println("Item '" + name + "' added. Cost: $" + cost + ".");
        return newItem;
    }

    public static void climberBuysAnItem(climber climber, item item) {
        climber.buyItem(item);
        System.out.println("Climber '" + climber.getName() + "' bought " + item.getName() + ".");
    }

    public static competition startCompetition(String name) {
        competition newCompetition = new competition(name);
        registeredCompetitions.add(newCompetition);
        System.out.println("Competition '" + name + "' started.");
        return newCompetition;
    }

    public static void climberRegistersToCompetition(climber climber, competition competition, Integer score) {
        competition.addResult(climber, score);
        System.out.println("Climber '" + climber.getName() + "' registered to competition " + competition.getName() + ".");
    }

    public static void closeCompetitionRegistration(competition competition) {
        competition.closeCompetition();
        System.out.println("Competition '" + competition.getName() + "' closed.");

        Set<Pair<climber, Integer>> leaderboard = competition.getLeaderboard();

        if (!leaderboard.isEmpty()) {
            Pair<climber, Integer> winnerEntry = leaderboard.iterator().next();
            assignBadge(winnerEntry.getKey(), getBadgeByName("Champion"));
        }
    }

    public static void showCompetition(competition competition) {
        competition.printLeaderboard();
    }

    public static incident reportIncident(incident incident) {
        registeredIncidents.add(incident);
        System.out.println("Reported incident: " + incident.getName());
        return incident;
    }

    public static void solveIncident(incident incident) {
        incident.markAsSolved();
    }

    public static void showUnsolvedMalfunctions() {
        Integer i = 1;
        for(incident incident : registeredIncidents) {
            if(incident instanceof malfunction && !incident.isSolved()) {
                System.out.println(i.toString() + ". " + incident.getName());
                i++;
            }
        }
    }
}
