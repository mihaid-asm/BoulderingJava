package utility;

import classes.*;

import java.util.ArrayList;
import java.util.List;

public class ServRoute {
    private static List<Route> routes = new ArrayList<>();

    public static Route createRoute(String name, double difficulty, Zone zone) {
        Route route = new Route(name, difficulty, zone);
        routes.add(route);
        System.out.println("Route '" + name + "' created on zone '" + zone.getName() + "'.");
        return route;
    }

    public static Route getRouteByName(String name) {
        for (Route route : routes) {
            if (route.getName().equals(name)) return route;
        }
        return null;
    }

    public static List<Route> getRoutes() {
        return routes;
    }
}