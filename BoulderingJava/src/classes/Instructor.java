package classes;

import interfaces.Persistence;
import utility.Pair;

import java.util.Vector;

public class Instructor implements Persistence {
    private int id;
    private String name;
    private Zone zone;

    public Instructor(int id, String name, Zone zone) {
        this.id = id;
        this.name = name;
        this.zone = zone;
    }

    public Instructor() {

    }

    public Instructor(int iid, String iname) {
        this.id = iid;
        this.name = iname;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public Zone getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return "instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zone=" + zone +
                '}';
    }

    @Override
    public String tableName() {
        return "Instructors";
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
