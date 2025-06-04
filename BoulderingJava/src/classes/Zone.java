package classes;

import interfaces.Persistence;
import utility.Pair;

import java.util.Vector;

public class Zone implements Persistence {
    int id;
    private String name;

    public Zone(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Zone() {

    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "boulderingZone{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String tableName() {
        return "Zones";
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
