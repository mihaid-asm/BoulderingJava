import classes.*;
import utility.*;
import interfaces.*;
import singleton.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        boolean inloop = true;

        while(inloop) {
            System.out.println("0. JAVA actions");
            System.out.println("1. DB actions");
            System.out.println("2. QUIT");
            System.out.println("Select type: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "0":
                    boolean running = true;

                    while (running) {
                        printMenu();
                        System.out.print("Select an option: ");
                        String javaOption = scanner.nextLine().trim().toUpperCase();

                        switch (javaOption) {
                            case "0" -> {
                                System.out.print("Enter id: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter climber name: ");
                                String name = scanner.nextLine();
                                ServClimber.registerClimber(id, name);
                            }
                            case "1" -> {
                                System.out.print("Enter id: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter zone name: ");
                                String name = scanner.nextLine();
                                ServZone.createZone(id, name);
                            }
                            case "2" -> {
                                System.out.print("Enter id: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter route name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter difficulty: ");
                                double diff = Double.parseDouble(scanner.nextLine());
                                System.out.print("Enter zone name: ");
                                String zoneName = scanner.nextLine();
                                Zone zone = ServZone.getZoneByName(zoneName);
                                if (zone != null) {
                                    ServRoute.createRoute(id, name, diff, zone);
                                } else {
                                    System.out.println("Zone not found.");
                                }
                            }
                            case "3" -> {
                                System.out.print("Enter id: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter instructor name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter zone name: ");
                                String zoneName = scanner.nextLine();
                                Zone zone = ServZone.getZoneByName(zoneName);
                                if (zone != null) {
                                    ServInstructor.hireInstructor(id, name, zone);
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
                                    comp.printLeaderboard();
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
                                System.out.println("Exiting JAVA actions menu...");
                                running = false;
                            }
                            default -> System.out.println("Invalid option. Please try again.");
                        }
                    }
                    break;

                case "1":
                    boolean running2 = true;

                    while (running2) {
                        printDBMenu();
                        System.out.print("Select a DB operation: ");
                        String dbOption = scanner.nextLine().trim().toUpperCase();

                        switch (dbOption) {
                            case "0" -> {
                                System.out.println("Creating all tables...");
                                new Climber().create();
                                new Zone().create();
                                new Route().create();
                                new Instructor().create();
                                Logs.log("Tables created.");
                            }

                            case "1" -> {
                                System.out.print("Which table? (climber | zone | route | instructor): ");
                                String tableToDelete = scanner.nextLine().trim().toLowerCase();

                                System.out.print("Enter ID to delete: ");
                                int deleteId = Integer.parseInt(scanner.nextLine());

                                switch (tableToDelete) {
                                    case "climber" -> {
                                        new Climber(deleteId, "").delete();
                                        System.out.println("Deleted climber with ID " + deleteId);
                                    }
                                    case "zone" -> {
                                        new Zone(deleteId, "").delete();
                                        System.out.println("Deleted zone with ID " + deleteId);
                                    }
                                    case "route" -> {
                                        new Route(deleteId, "", 0.0, new Zone(0, "")).delete();
                                        System.out.println("Deleted route with ID " + deleteId);
                                    }
                                    case "instructor" -> {
                                        new Instructor(deleteId, "", new Zone(0, "")).delete();
                                        System.out.println("Deleted instructor with ID " + deleteId);
                                    }
                                    default -> System.out.println("Unknown table name.");
                                }
                                Logs.log("deleted from " + tableToDelete);
                            }

                            case "2" -> {
                                System.out.print("Which table to insert into? (climber | zone | route | instructor): ");
                                String tableToInsert = scanner.nextLine().trim().toLowerCase();

                                switch (tableToInsert) {
                                    case "climber" -> {
                                        System.out.print("Enter climber ID: ");
                                        int cid = Integer.parseInt(scanner.nextLine());
                                        System.out.print("Enter climber name: ");
                                        String cname = scanner.nextLine();

                                        Climber c = new Climber(cid, cname);
                                        c.create();
                                        c.insert();
                                        System.out.println("Inserted climber: " + cname);
                                    }

                                    case "zone" -> {
                                        System.out.print("Enter zone ID: ");
                                        int zid = Integer.parseInt(scanner.nextLine());
                                        System.out.print("Enter zone name: ");
                                        String zname = scanner.nextLine();

                                        Zone z = new Zone(zid, zname);
                                        z.create();
                                        z.insert();
                                        System.out.println("Inserted zone: " + zname);
                                    }

                                    case "route" -> {
                                        System.out.print("Enter route ID: ");
                                        int rid = Integer.parseInt(scanner.nextLine());
                                        System.out.print("Enter route name: ");
                                        String rname = scanner.nextLine();

                                        Route r = new Route(rid, rname);
                                        r.create();
                                        r.insert();
                                        System.out.println("Inserted route: " + rname);
                                    }

                                    case "instructor" -> {
                                        System.out.print("Enter instructor ID: ");
                                        int iid = Integer.parseInt(scanner.nextLine());
                                        System.out.print("Enter instructor name: ");
                                        String iname = scanner.nextLine();

                                        Instructor i = new Instructor(iid, iname);
                                        i.create();
                                        i.insert();
                                        System.out.println("Inserted instructor: " + iname);
                                    }

                                    default -> System.out.println("Unknown table name.");

                                }

                                Logs.log("inserted in " + tableToInsert);
                            }

                            case "3" -> {
                                System.out.print("Which table to load from? (climber | zone | route | instructor): ");
                                String tableToLoad = scanner.nextLine().trim().toLowerCase();

                                System.out.print("Enter ID to load: ");
                                int loadId = Integer.parseInt(scanner.nextLine());

                                switch (tableToLoad) {
                                    case "climber" -> {
                                        Optional<Vector<String>> cData = new Climber(loadId, "").load(loadId);
                                        System.out.println(
                                                cData.isPresent() ? "Climber data: " + cData.get()
                                                        : "Climber ID " + loadId + " not found."
                                        );
                                    }
                                    case "zone" -> {
                                        Optional<Vector<String>> zData = new Zone(loadId, "").load(loadId);
                                        System.out.println(
                                                zData.isPresent() ? "Zone data: " + zData.get()
                                                        : "Zone ID " + loadId + " not found."
                                        );
                                    }
                                    case "route" -> {
                                        Optional<Vector<String>> rData = new Route(loadId, "", 0.0, new Zone(0, "")).load(loadId);
                                        System.out.println(
                                                rData.isPresent() ? "Route data: " + rData.get()
                                                        : "Route ID " + loadId + " not found."
                                        );
                                    }
                                    case "instructor" -> {
                                        Optional<Vector<String>> iData = new Instructor(loadId, "", new Zone(0, "")).load(loadId);
                                        System.out.println(
                                                iData.isPresent() ? "Instructor data: " + iData.get()
                                                        : "Instructor ID " + loadId + " not found."
                                        );
                                    }
                                    default -> System.out.println("Unknown table name.");
                                }
                                Logs.log("loaded from " + tableToLoad);
                            }

                            case "4" -> {
                                System.out.print("Enter table to update (climber/zone/route/instructor): ");
                                String tableToUpdate = scanner.nextLine().trim().toLowerCase();
                                switch (tableToUpdate) {
                                    case "climber" -> {
                                        System.out.print("Enter climber ID: ");
                                        int id = Integer.parseInt(scanner.nextLine());
                                        System.out.print("Enter new climber name: ");
                                        String name = scanner.nextLine();
                                        new Climber(id, name).update();
                                        System.out.println("Climber updated.");
                                    }
                                    case "zone" -> {
                                        System.out.print("Enter zone ID: ");
                                        int id = Integer.parseInt(scanner.nextLine());
                                        System.out.print("Enter new zone name: ");
                                        String name = scanner.nextLine();
                                        new Zone(id, name).update();
                                        System.out.println("Zone updated.");
                                    }
                                    case "route" -> {
                                        System.out.print("Enter route ID: ");
                                        int id = Integer.parseInt(scanner.nextLine());
                                        System.out.print("Enter new route name: ");
                                        String name = scanner.nextLine();
                                        new Route(id, name).update();
                                        System.out.println("Route updated.");
                                    }
                                    case "instructor" -> {
                                        System.out.print("Enter instructor ID: ");
                                        int id = Integer.parseInt(scanner.nextLine());
                                        System.out.print("Enter new instructor name: ");
                                        String name = scanner.nextLine();
                                        new Instructor(id, name).update();
                                        System.out.println("Instructor updated.");
                                    }
                                    default -> System.out.println("Unknown table name.");
                                }
                                Logs.log("updated from " + tableToUpdate);
                            }

                            case "5" -> {
                                running2 = false;
                                System.out.println("Exiting DB actions menu...");
                            }

                            default -> System.out.println("Invalid DB option.");

                        }
                    }
                    break;
                case "2":
                    inloop = false;
                    Logs.save_logs();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
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
        System.out.println("Z. Back to Main Menu");
    }

    private static void printDBMenu() {
        System.out.println("===== DATABASE ACTIONS =====");
        System.out.println("0. Create All Tables");
        System.out.println("1. Delete from Table");
        System.out.println("2. Insert into Table");
        System.out.println("3. Load a record");
        System.out.println("4. Update a record");
        System.out.println("5. Back to Main Menu");
    }
}