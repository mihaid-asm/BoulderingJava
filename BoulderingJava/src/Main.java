import classes.*;
import utility.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "0" -> {
                    System.out.print("Enter climber name: ");
                    String name = scanner.nextLine();
                    ServClimber.registerClimber(name);
                }
                case "1" -> {
                    System.out.print("Enter zone name: ");
                    String name = scanner.nextLine();
                    ServZone.createZone(name);
                }
                case "2" -> {
                    System.out.print("Enter route name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter difficulty: ");
                    double diff = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter zone name: ");
                    String zoneName = scanner.nextLine();
                    Zone zone = ServZone.getZoneByName(zoneName);
                    if (zone != null) {
                        ServRoute.createRoute(name, diff, zone);
                    } else {
                        System.out.println("Zone not found.");
                    }
                }
                case "3" -> {
                    System.out.print("Enter instructor name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter zone name: ");
                    String zoneName = scanner.nextLine();
                    Zone zone = ServZone.getZoneByName(zoneName);
                    if (zone != null) {
                        ServInstructor.hireInstructor(name, zone);
                    } else {
                        System.out.println("Zone not found.");
                    }
                }
                case "4" -> {
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item cost: ");
                    double cost = Double.parseDouble(scanner.nextLine());
                    ServItem.addItem(name, cost);
                }
                case "5" -> {
                    System.out.print("Enter competition name: ");
                    String name = scanner.nextLine();
                    ServCompetition.startCompetition(name);
                }
                case "6" -> {
                    System.out.print("Enter accident name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter zone name: ");
                    String zoneName = scanner.nextLine();
                    Zone zone = ServZone.getZoneByName(zoneName);
                    System.out.print("Enter climber name: ");
                    String climberName = scanner.nextLine();
                    Climber climber = ServClimber.getClimberByName(climberName);
                    if (zone != null && climber != null) {
                        ServIncident.reportIncident(new Accident(name, desc, zone, climber));
                    } else {
                        System.out.println("Zone or climber not found.");
                    }
                }
                case "7" -> {
                    System.out.print("Enter malfunction name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter zone name: ");
                    String zoneName = scanner.nextLine();
                    Zone zone = ServZone.getZoneByName(zoneName);
                    System.out.print("Enter route name: ");
                    String routeName = scanner.nextLine();
                    Route route = ServRoute.getRouteByName(routeName);
                    if (zone != null && route != null) {
                        ServIncident.reportIncident(new Malfunction(name, desc, zone, route));
                    } else {
                        System.out.println("Zone or route not found.");
                    }
                }
                case "8" -> {
                    System.out.print("Enter incident name: ");
                    String name = scanner.nextLine();
                    Incident incident = ServIncident.getIncidentByName(name);
                    if (incident != null) {
                        ServIncident.solveIncident(incident);
                    } else {
                        System.out.println("Incident not found.");
                    }
                }
                case "9" -> ServIncident.showUnsolvedMalfunctions();
                case "A" -> {
                    System.out.print("Enter climber name: ");
                    String climberName = scanner.nextLine();
                    Climber climber = ServClimber.getClimberByName(climberName);
                    System.out.print("Enter competition name: ");
                    String compName = scanner.nextLine();
                    Competition competition = ServCompetition.getCompetitionByName(compName);
                    System.out.print("Enter score: ");
                    int score = Integer.parseInt(scanner.nextLine());
                    if (climber != null && competition != null) {
                        ServCompetition.climberRegistersToCompetition(climber, competition, score);
                    } else {
                        System.out.println("Climber or competition not found.");
                    }
                }
                case "B" -> {
                    System.out.print("Enter competition name: ");
                    String compName = scanner.nextLine();
                    Competition comp = ServCompetition.getCompetitionByName(compName);
                    if (comp != null) {
                        ServCompetition.closeCompetitionRegistration(comp);
                    } else {
                        System.out.println("Competition not found.");
                    }
                }
                case "C" -> {
                    System.out.print("Enter climber name: ");
                    String name = scanner.nextLine();
                    Climber climber = ServClimber.getClimberByName(name);
                    if (climber != null) {
                        List<Badge> badges = ServBadge.getBadgesByClimber(climber);
                        System.out.println("Badges: " + badges);
                    } else {
                        System.out.println("Climber not found.");
                    }
                }
                case "D" -> {
                    System.out.print("Enter climber name: ");
                    String climberName = scanner.nextLine();
                    Climber climber = ServClimber.getClimberByName(climberName);
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    Item item = ServItem.getItemByName(itemName);
                    if (climber != null && item != null) {
                        ServClimber.climberBuysAnItem(climber, item);
                    } else {
                        System.out.println("Climber or item not found.");
                    }
                }
                case "E" -> {
                    System.out.print("Enter climber name: ");
                    String climberName = scanner.nextLine();
                    Climber climber = ServClimber.getClimberByName(climberName);
                    System.out.print("Enter route name: ");
                    String routeName = scanner.nextLine();
                    Route route = ServRoute.getRouteByName(routeName);
                    System.out.print("Enter time in seconds: ");
                    int time = Integer.parseInt(scanner.nextLine());
                    if (climber != null && route != null) {
                        ServClimber.completeRoute(climber, route, time);
                    } else {
                        System.out.println("Climber or route not found.");
                    }
                }
                case "F" -> {
                    System.out.println("All registered climbers:");
                    System.out.println(ServClimber.getClimbers());
                }
                case "Z" -> {
                    System.out.println("Exiting program...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== BOULDERING MENU =====");
        System.out.println("0. Register Climber");
        System.out.println("1. Add Zone");
        System.out.println("2. Add Route");
        System.out.println("3. Hire Instructor");
        System.out.println("4. Add an Item");
        System.out.println("5. Start a Competition");
        System.out.println("6. Report an Accident");
        System.out.println("7. Report a Malfunction");
        System.out.println("8. Mark Incident as Solved");
        System.out.println("9. Show All Unsolved Malfunctions");
        System.out.println("A. Register a Climber in a Competition");
        System.out.println("B. Close a Competition");
        System.out.println("C. Show a Climber's Badges");
        System.out.println("D. Buy an Item");
        System.out.println("E. Complete a Route");
        System.out.println("F. Show All Climbers");
        System.out.println("Z. Exit");
    }
}