package utility;

import classes.*;

import java.util.ArrayList;
import java.util.List;

public class ServZone {
    private static List<Zone> zones = new ArrayList<>();

    public static Zone createZone(String name) {
        Zone zone = new Zone(name);
        zones.add(zone);
        System.out.println("Zone '" + name + "' created.");
        return zone;
    }

    public static Zone getZoneByName(String name) {
        for (Zone zone : zones) {
            if (zone.getName().equals(name)) return zone;
        }
        return null;
    }

    public static List<Zone> getZones() {
        return zones;
    }
}